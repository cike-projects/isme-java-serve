package cn.dhbin.isme.pms.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户信息
 *
 * @author dhb
 */
@Data
@Accessors(chain = true)
public class ProfileDto {

    private Integer id;

    private Integer gender;

    private String avatar;

    private String address;

    private String email;

    private Integer userId;

    private String nickName;

}
