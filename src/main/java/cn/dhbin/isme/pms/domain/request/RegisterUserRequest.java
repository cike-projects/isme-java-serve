package cn.dhbin.isme.pms.domain.request;

import cn.dhbin.isme.repository.sherry.entity.User;
import java.util.List;
import lombok.Data;

/**
 * 注册用户
 *
 * @author dhb
 */
@Data
public class RegisterUserRequest {

    private String username;

    private String password;

    private Boolean enable;

    private RegisterUserProfileRequest profile;

    private List<Integer> roleIds;


  public User convert() {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setEnable(enable ? (byte) 1 : (byte) 0);
    return user;
  }
}
