package cn.dhbin.isme.pms.domain.request;


import cn.dhbin.isme.repository.sherry.entity.Role;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;

/**
 * 创建角色
 *
 * @author dhb
 */
@Data
public class CreateRoleRequest {

    @NotBlank(message = "角色编码不能为空")
    private String code;

    @NotBlank(message = "角色名不能为空")
    private String name;

    private List<Integer> permissionIds;

    private Boolean enable;


  public Role convert() {
     Role role = new Role();
     role.setCode(code);
     role.setName(name);
     role.setEnable((byte) (enable ? 1 : 0));

      return role;
  }
}
