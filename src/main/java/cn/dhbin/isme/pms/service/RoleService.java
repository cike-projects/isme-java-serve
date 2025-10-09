package cn.dhbin.isme.pms.service;

import cn.dhbin.isme.common.auth.RoleType;
import cn.dhbin.isme.common.exception.BadRequestException;
import cn.dhbin.isme.common.response.PageList;
import cn.dhbin.isme.pms.domain.dto.PermissionDto;
import cn.dhbin.isme.pms.domain.dto.RoleDto;
import cn.dhbin.isme.pms.domain.dto.RolePageDto;
import cn.dhbin.isme.pms.domain.request.AddRolePermissionsRequest;
import cn.dhbin.isme.pms.domain.request.AddRoleUsersRequest;
import cn.dhbin.isme.pms.domain.request.CreateRoleRequest;
import cn.dhbin.isme.pms.domain.request.RemoveRoleUsersRequest;
import cn.dhbin.isme.pms.domain.request.RolePageRequest;
import cn.dhbin.isme.pms.domain.request.UpdateRoleRequest;
import cn.dhbin.isme.pms.util.PermissionUtil;
import cn.dhbin.isme.repository.sherry.PermissionRepository;
import cn.dhbin.isme.repository.sherry.RolePermissionRepository;
import cn.dhbin.isme.repository.sherry.RoleRepository;
import cn.dhbin.isme.repository.sherry.UserRoleRepository;
import cn.dhbin.isme.repository.sherry.entity.Permission;
import cn.dhbin.isme.repository.sherry.entity.Role;
import cn.dhbin.isme.repository.sherry.entity.RolePermissionsPermission;
import cn.dhbin.isme.repository.sherry.entity.UserRolesRole;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RoleServiceImpl
 *
 * @author dhb
 */
@Service
@RequiredArgsConstructor
public class RoleService {

  private final PermissionService permissionService;

  private final UserRoleRepository userRoleRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PermissionRepository permissionRepository;

  private final RolePermissionRepository rolePermissionRepository;


  public List<Role> findRolesByUserId(int userId) {
    return roleRepository.findRolesByUserId(userId);
  }


  public List<Tree<Integer>> findRolePermissionsTree(String roleCode) {
    Role role = roleRepository.findByCode(roleCode);
    if (role == null) {
      throw new RuntimeException("当前角色不存在或者已删除");
    }
    List<Permission> permissions =
        "SUPER_ADMIN".equals(roleCode) ? permissionRepository.all()
            : permissionRepository.findByRoleId(role.getId());
    List<PermissionDto> permissionDtos = permissions.stream().map(PermissionService::toDto).toList();

    return PermissionUtil.toTreeNode(permissionDtos, null);
  }


  public Role findByCode(String roleCode) {
    return roleRepository.findByCode(roleCode);
  }


  @Transactional(rollbackFor = Exception.class)
  public void createRole(CreateRoleRequest request) {
    boolean exists = roleRepository.existsByCodeOrName(request.getCode(), request.getName());
    if (exists) {
      throw new BadRequestException("角色已存在（角色名和角色编码不能重复）");
    }

    Role role = request.convert();
    roleRepository.save(role);
    List<RolePermissionsPermission> permissionList = request.getPermissionIds().stream()
        .map(permId -> {
          RolePermissionsPermission rolePermission = new RolePermissionsPermission();
          rolePermission.setRoleid(role.getId());
          rolePermission.setPermissionid(permId);
          return rolePermission;
        }).toList();
    rolePermissionRepository.saveBatch(permissionList);
  }


  public PageList<RolePageDto> queryPage(RolePageRequest request) {
    com.github.pagehelper.Page<Object> page = request.toPage();

    List<Role> roles = roleRepository.findByCodeOrName(request.getName(), request.getName());

    List<RolePageDto> list = roles.stream()
        .map(role -> {
      return new RolePageDto()
          .setId(role.getId())
          .setCode(role.getCode())
          .setName(role.getName())
          .setEnable(role.getEnable() == 1)
          .setPermissionIds(rolePermissionRepository.getPermissionIdByRoRoleId(role.getId()));
    }).toList();


    return PageList.of(request.getPageNo(), request.getPageSize(), page.getTotal(), list);
  }


  public List<PermissionDto> findRolePermissions(int id) {
    return permissionService.findByRoleId(id)
        .stream()
        .map(PermissionService::toDto)
        .toList();
  }


  @Transactional(rollbackFor = Exception.class)
  public void updateRole(int id, UpdateRoleRequest request) {
    Role role = getById(id);
    if (role == null) {
      throw new BadRequestException("角色不存在或者已删除");
    }
    if (RoleType.SUPER_ADMIN.equals(role.getCode())) {
      throw new BadRequestException("不允许修改超级管理员");
    }
    if (StrUtil.isNotBlank(request.getName())) {
      role.setName(request.getName());
    }
    if (ObjectUtil.isNotNull(request.getEnable())) {
      role.setEnable((byte) (request.getEnable() ? 1 : 0));
    }

    roleRepository.updateById(role);
    if (request.getPermissionIds() != null) {
      rolePermissionRepository.deleteByRoleId(id);
      if (!request.getPermissionIds().isEmpty()) {
        List<RolePermissionsPermission> permissionList = request.getPermissionIds().stream()
            .map(permId -> {
              RolePermissionsPermission rolePermission = new RolePermissionsPermission();
              rolePermission.setRoleid(id);
              rolePermission.setPermissionid(permId);
              return rolePermission;
            }).toList();
        rolePermissionRepository.saveBatch(permissionList);
      }
    }
  }


  @Transactional(rollbackFor = Exception.class)
  public void removeRole(int roleId) {
    Role role = getById(roleId);
    if (role == null) {
      throw new BadRequestException("角色不存在或者已删除");
    }
    if (RoleType.SUPER_ADMIN.equals(role.getCode())) {
      throw new BadRequestException("不允许修改超级管理员");
    }
    roleRepository.deleteById(roleId);
    userRoleRepository.deleteByRoleId(roleId);
    rolePermissionRepository.deleteByRoleId(roleId);
  }

  @Transactional(rollbackFor = Exception.class)
  public void addRolePermissions(AddRolePermissionsRequest request) {
    Role role = getById(request.getId());
    if (role == null) {
      throw new BadRequestException("角色不存在或者已删除");
    }
    if (RoleType.SUPER_ADMIN.equals(role.getCode())) {
      throw new BadRequestException("无需给超级管理员授权");
    }
    List<Integer> list = rolePermissionRepository.getPermissionIdByRoRoleId(role.getId());

    CollUtil.removeWithAddIf(request.getPermissionIds(), list::contains);
    List<RolePermissionsPermission> permissionList = request.getPermissionIds()
        .stream()
        .map(permId -> {
          RolePermissionsPermission rolePermission = new RolePermissionsPermission();
          rolePermission.setRoleid(role.getId());
          rolePermission.setPermissionid(permId);
          return rolePermission;
        }).toList();
    rolePermissionRepository.saveBatch(permissionList);
  }


  @Transactional(rollbackFor = Exception.class)
  public void addRoleUsers(int roleId, AddRoleUsersRequest request) {
    Role role = roleRepository.getById(roleId);
    if (role == null) {
      throw new BadRequestException("角色不存在或者已删除");
    }
    List<Integer> list = userRoleRepository.getAllUserIdByRoleId(roleId);

    CollUtil.removeWithAddIf(request.getUserIds(), list::contains);
    List<UserRolesRole> permissionList = request.getUserIds()
        .stream()
        .map(userId -> {
          UserRolesRole userRole = new UserRolesRole();
          userRole.setRoleid(roleId);
          userRole.setUserid(userId);
          return userRole;
        }).toList();
    userRoleRepository.saveBatch(permissionList);
  }


  @Transactional(rollbackFor = Exception.class)
  public void removeRoleUsers(Integer roleId, RemoveRoleUsersRequest request) {
    Role role = roleRepository.getById(roleId);
    if (role == null) {
      throw new BadRequestException("角色不存在或者已删除");
    }

    userRoleRepository.deleteByRoleIdAndUserIds(roleId, request.getUserIds());
  }

  public List<RoleDto> getBy(Boolean enable) {
    List<Role> roles = roleRepository.getByNameAndEnable(null, enable);
    return roles.stream().map(RoleService::toDto).toList();
  }

  public static RoleDto toDto(Role role) {
    RoleDto roleDto = new RoleDto();
    roleDto.setId(role.getId());
    roleDto.setCode(role.getCode());
    roleDto.setName(role.getName());
    roleDto.setEnable(role.getEnable() == 1);
    return roleDto;
  }

  public Role getById(int id) {
    return roleRepository.getById(id);
  }
}
