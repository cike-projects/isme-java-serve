package cn.dhbin.isme.pms.domain.request;

import cn.dhbin.isme.pms.util.ConvertUtil;
import cn.dhbin.isme.repository.sherry.entity.Permission;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 创建权限
 *
 * @author dhb
 */
@Data
public class CreatePermissionRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    @NotBlank
    private String type;


    private Integer parentId;

    private String path;

    private String redirect;

    private String icon;

    private String component;

    private String layout;

    private Boolean keepAlive;

    private String method;

    private String description;

    private Boolean show;

    private Boolean enable;

    private Integer order;

  public Permission convert() {
    Permission permission = new Permission();
    permission.setName(name);
    permission.setCode(code);
    permission.setType(type);
    permission.setParentid(parentId);
    permission.setPath(path);
    permission.setRedirect(redirect);
    permission.setIcon(icon);
    permission.setComponent(component);
    permission.setLayout(layout);
    permission.setKeepalive(ConvertUtil.toByte(keepAlive));
    permission.setMethod(method);
    permission.setDescription(description);
    permission.setShow(ConvertUtil.toByte(show));
    permission.setEnable(ConvertUtil.toByte(enable));
    permission.setOrder(order);
    return permission;
  }
}
