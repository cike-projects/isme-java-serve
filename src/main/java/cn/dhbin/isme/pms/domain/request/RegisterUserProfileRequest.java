package cn.dhbin.isme.pms.domain.request;

import cn.dhbin.isme.repository.sherry.entity.Profile;
import lombok.Data;

/**
 * 注册用户的用户信息
 *
 * @author dhb
 */
@Data
public class RegisterUserProfileRequest {

    private String nickName;

    private Integer gender;

    private String avatar;

    private String address;

    private String email;


  public Profile convert() {
    Profile profile = new Profile();
    profile.setNickname(nickName);
    profile.setGender(gender);
    profile.setAvatar(avatar);
    profile.setAddress(address);
    profile.setEmail(email);
    return profile;
  }
}
