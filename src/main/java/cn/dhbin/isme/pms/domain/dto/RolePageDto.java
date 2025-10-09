package cn.dhbin.isme.pms.domain.dto;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色Dto
 *
 * @author dhb
 */
@Data
@Accessors(chain = true)
public class RolePageDto {

    private Integer id;

    private String code;

    private String name;

    private Boolean enable;

    private List<Integer> permissionIds;

}
