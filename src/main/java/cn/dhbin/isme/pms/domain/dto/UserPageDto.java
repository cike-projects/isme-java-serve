package cn.dhbin.isme.pms.domain.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户分页数据
 */
@Data
@Accessors(chain = true)
public class UserPageDto {

    private Integer id;

    private String username;

    private Boolean enable;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer gender;

    private String avatar;

    private String address;

    private String email;

    private List<RoleDto> roles;


}
