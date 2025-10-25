package cn.dhbin.isme.pms.service;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dhbin.isme.common.auth.SaTokenConfigure;
import cn.dhbin.isme.common.exception.BizException;
import cn.dhbin.isme.common.response.BizResponseCode;
import cn.dhbin.isme.common.response.PageList;
import cn.dhbin.isme.pms.domain.dto.LoginTokenDto;
import cn.dhbin.isme.pms.domain.dto.ProfileDto;
import cn.dhbin.isme.pms.domain.dto.RoleDto;
import cn.dhbin.isme.pms.domain.dto.UserDetailDto;
import cn.dhbin.isme.pms.domain.dto.UserPageDto;
import cn.dhbin.isme.pms.domain.request.AddUserRolesRequest;
import cn.dhbin.isme.pms.domain.request.ChangePasswordRequest;
import cn.dhbin.isme.pms.domain.request.LoginRequest;
import cn.dhbin.isme.pms.domain.request.RegisterUserProfileRequest;
import cn.dhbin.isme.pms.domain.request.RegisterUserRequest;
import cn.dhbin.isme.pms.domain.request.UpdatePasswordRequest;
import cn.dhbin.isme.pms.domain.request.UpdateProfileRequest;
import cn.dhbin.isme.pms.domain.request.UpdateUserRequest;
import cn.dhbin.isme.pms.domain.request.UserPageRequest;
import cn.dhbin.isme.repository.sherry.ProfileRepository;
import cn.dhbin.isme.repository.sherry.RoleRepository;
import cn.dhbin.isme.repository.sherry.UserRepository;
import cn.dhbin.isme.repository.sherry.UserRoleRepository;
import cn.dhbin.isme.repository.sherry.entity.Profile;
import cn.dhbin.isme.repository.sherry.entity.Role;
import cn.dhbin.isme.repository.sherry.entity.User;
import cn.dhbin.isme.repository.sherry.entity.UserRolesRole;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.digest.BCrypt;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User Service impl
 *
 * @author dhb
 */
@Service
@RequiredArgsConstructor
public class UserService {

  private final RoleService roleService;

  private final ProfileService profileService;

  private final CaptchaService captchaService;

  @Autowired
  private UserRepository userRepository;

  private final RoleRepository roleRepository;

  private final ProfileRepository profileRepository;
  private final UserRoleRepository userRoleRepository;


  public LoginTokenDto login(LoginRequest request) {
    User user = userRepository.findByUsername(request.getUsername());
    if (user == null) {
      throw new BizException(BizResponseCode.ERR_10002);
    }
    // 预览环境下可快速登录，不用验证码
    if (Boolean.TRUE.equals(request.getIsQuick())) {
      return login(request, user);
    }
//        if (StrUtil.isBlank(request.getCaptchaKey())
//            || !captchaService.verify(request.getCaptchaKey(), request.getCaptcha())) {
//            throw new BizException(BizResponseCode.ERR_10003);
//        }
    return login(request, user);
  }

  private LoginTokenDto login(LoginRequest request, User user) {
    boolean checkPw = BCrypt.checkpw(request.getPassword(), user.getPassword());
    if (checkPw) {
      // 查询用户的角色
      List<Role> roles = roleService.findRolesByUserId(user.getId());
      return generateToken(user, roles, roles.isEmpty() ? "" : roles.getFirst().getCode());
    }
    else {
      throw new BizException(BizResponseCode.ERR_10002);
    }
  }


  public UserDetailDto detail(int userId, String roleCode) {
    User user = userRepository.getById(userId);
    UserDetailDto userDetailDto = new UserDetailDto();
    userDetailDto.setId((long) user.getId())
        .setUsername(user.getUsername())
        .setEnable(user.getEnable() == 1)
        .setCreateTime(user.getCreatetime())
        .setUpdateTime(user.getUpdatetime());

    Profile profile = profileRepository.findByUserId(userId);

    ProfileDto profileDto = new ProfileDto()
        .setId(profile.getId())
        .setGender(profile.getGender())
        .setAvatar(profile.getAvatar())
        .setAddress(profile.getAddress())
        .setEmail(profile.getEmail())
        .setUserId(profile.getUserid())
        .setNickName(profile.getNickname());

    List<RoleDto> roleDtoList = roleRepository.findRolesByUserId(userId)
        .stream()
        .filter(it -> it.getEnable() == 1)
        .map(role -> new RoleDto()
            .setId(role.getId())
            .setCode(role.getCode())
            .setName(role.getName())
            .setEnable(role.getEnable() == 1)
        )
        .toList();
    if (roleDtoList.isEmpty()) {
//      throw new BizException(BizResponseCode.ERR_11005);
    }

    userDetailDto.setProfile(profileDto);
    userDetailDto.setRoles(roleDtoList);

    for (RoleDto roleDto : roleDtoList) {
      if (roleDto.getCode().equals(roleCode)) {
        userDetailDto.setCurrentRole(roleDto);
        break;
      }
    }
    return userDetailDto;
  }


  public LoginTokenDto switchRole(int userId, String roleCode) {
    User user = userRepository.getById(userId);
    List<Role> roles = roleService.findRolesByUserId(userId);
    Role currentRole = null;
    for (Role role : roles) {
      if (roleCode.equals(role.getCode())) {
        currentRole = role;
      }
    }
    if (currentRole == null) {
      throw new BizException(BizResponseCode.ERR_11005);
    }
    return generateToken(user, roles, currentRole.getCode());
  }


  @Transactional(rollbackFor = Exception.class)
  public void register(RegisterUserRequest request) {
    boolean exists = userRepository.exists(request.getUsername());
    if (exists) {
      throw new BizException(BizResponseCode.ERR_10001);
    }
    User user = request.convert();
    user.setPassword(BCrypt.hashpw(user.getPassword()));
    userRepository.save(user);

    Profile profile = Optional.ofNullable(request.getProfile()).orElse(new RegisterUserProfileRequest()).convert();
    profile.setUserid(user.getId());
    if (CollUtil.isNotEmpty(request.getRoleIds())) {
      List<UserRolesRole> roleList = request.getRoleIds().stream()
          .map(roleId -> {
            UserRolesRole userRole = new UserRolesRole();
            userRole.setUserid(user.getId());
            userRole.setRoleid(roleId);
            return userRole;
          }).toList();
      userRoleRepository.saveBatch(roleList);
    }
    profileService.save(profile);
  }


  public LoginTokenDto refreshToken() {
    SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
    StpUtil.login(tokenInfo.getLoginId(), SaLoginConfig
        .setExtra(SaTokenConfigure.JWT_USER_ID_KEY,
            StpUtil.getExtra(SaTokenConfigure.JWT_USER_ID_KEY))
        .setExtra(SaTokenConfigure.JWT_USERNAME_KEY,
            StpUtil.getExtra(SaTokenConfigure.JWT_USERNAME_KEY))
        .setExtra(SaTokenConfigure.JWT_CURRENT_ROLE_KEY,
            StpUtil.getExtra(SaTokenConfigure.JWT_CURRENT_ROLE_KEY))
        .setExtra(SaTokenConfigure.JWT_ROLE_LIST_KEY,
            StpUtil.getExtra(SaTokenConfigure.JWT_ROLE_LIST_KEY))
    );
    SaTokenInfo newTokenInfo = StpUtil.getTokenInfo();
    LoginTokenDto dto = new LoginTokenDto();
    dto.setAccessToken(newTokenInfo.getTokenValue());
    return dto;
  }


  public void changePassword(ChangePasswordRequest request) {
    String username = (String) StpUtil.getExtra(SaTokenConfigure.JWT_USERNAME_KEY);
    User user = userRepository.findByUsername(username);
    if (!BCrypt.checkpw(request.getOldPassword(), user.getPassword())) {
      throw new BizException(BizResponseCode.ERR_10004);
    }
    user.setPassword(BCrypt.hashpw(request.getNewPassword()));
    userRepository.update(user);
    StpUtil.logout();
  }


  public PageList<UserPageDto> queryPage(UserPageRequest request) {

    com.github.pagehelper.Page<Object> page = request.toPage();
    List<User> users = userRepository.getBy(request.getUsername(), request.getEnable(), request.getGender());

    List<UserPageDto> list = users.stream()
        .map(user -> {
              Profile profile = profileRepository.findByUserId(user.getId());

              return new UserPageDto()
                  .setId(user.getId())
                  .setUsername(user.getUsername())
                  .setAvatar(profile.getAvatar())
                  .setEnable(user.getEnable() == 1)
                  .setCreateTime(user.getCreatetime())
                  .setUpdateTime(user.getUpdatetime())
                  .setRoles(
                      roleRepository.findRolesByUserId(user.getId())
                          .stream()
                          .map(role -> new RoleDto()
                              .setId(role.getId())
                              .setCode(role.getCode())
                              .setName(role.getName())
                              .setEnable(role.getEnable() == 1)
                          )
                          .toList()
                  );
            }
        ).toList();
    return PageList.of(request.getPageNo(), request.getPageSize(), page.getTotal(), list);
  }


  @Transactional(rollbackFor = Exception.class)
  public void removeUser(int id) {
    if (id == 1) {
      throw new BizException(BizResponseCode.ERR_11006, "不能删除根用户");
    }
    userRepository.removeUser(id);
    profileService.removeByUserId(id);
  }


  public void resetPassword(int userId, UpdatePasswordRequest request) {
    String newPw = BCrypt.hashpw(request.getPassword());
    User user = new User();
    user.setId(userId);
    user.setPassword(newPw);
    userRepository.update(user);
  }


  @Transactional(rollbackFor = Exception.class)
  public void addRoles(int userId, AddUserRolesRequest request) {
    userRoleRepository.deleteByUserId(userId);
    List<UserRolesRole> list = request.getRoleIds().stream()
        .map(roleId -> {
          UserRolesRole userRole = new UserRolesRole();
          userRole.setUserid(userId);
          userRole.setRoleid(roleId);
          return userRole;
        }).toList();
    userRoleRepository.saveBatch(list);
  }


  public void updateProfile(Long id, UpdateProfileRequest request) {
    Profile profile = request.convert();
    profileService.updateById(profile);
  }


  @Transactional(rollbackFor = Exception.class)
  public void updateById(int id, UpdateUserRequest request) {
    if (request.getRoleIds() != null) {
      AddUserRolesRequest addUserRolesRequest = new AddUserRolesRequest();
      addUserRolesRequest.setRoleIds(request.getRoleIds());
      addRoles(id, addUserRolesRequest);
    }
    if (request.getEnable() != null) {
      User user = new User();
      user.setId(id);
      user.setEnable(request.getEnable() ? (byte) 1 : (byte) 0);
      userRepository.update(user);
    }
  }


  private LoginTokenDto generateToken(User user, List<Role> roles, String currentRoleCode) {
    // 密码验证成功
    StpUtil.login(user.getId());
    SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
    LoginTokenDto dto = new LoginTokenDto();
    dto.setAccessToken(tokenInfo.getTokenValue());
    return dto;
  }

}
