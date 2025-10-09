package cn.dhbin.isme.common.auth;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 鉴权
 *
 * @author dhb
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    public List<String> getRoleList(Object loginId, String loginType) {
        String role = (String) StpUtil.getExtra(SaTokenConfigure.JWT_CURRENT_ROLE_KEY);
        return CollUtil.newArrayList(role);
    }
}
