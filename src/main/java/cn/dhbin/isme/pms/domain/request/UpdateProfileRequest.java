package cn.dhbin.isme.pms.domain.request;

import cn.dhbin.isme.repository.sherry.entity.Profile;
import lombok.Data;

/**
 * 更新用户信息
 *
 * @author dhb
 */
@Data
public class UpdateProfileRequest {
    private int id;
    private Integer gender;
    private String address;
    private String email;
    private String avatar;
    private String nickName;

  public Profile convert() {
    Profile profile = new Profile();
    profile.setId(id);
    profile.setGender(gender);
    profile.setAddress(address);
    profile.setEmail(email);
    profile.setAvatar(avatar);
    profile.setNickname(nickName);
    return profile;
  }
}
