package cn.dhbin.isme.pms.domain.request;

import java.util.List;
import lombok.Data;

/**
 * 更新用户
 *
 * @author dhb
 */
@Data
public class UpdateUserRequest {

    private List<Integer> roleIds;

    private Boolean enable;

}
