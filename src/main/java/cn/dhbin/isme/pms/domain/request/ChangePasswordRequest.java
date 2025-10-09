package cn.dhbin.isme.pms.domain.request;

import lombok.Data;

/**
 * 修改密码请求
 *
 * @author dhb
 */
@Data
public class ChangePasswordRequest {


    private String oldPassword;

    private String newPassword;

}
