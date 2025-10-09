package cn.dhbin.isme.pms.domain.request;


import cn.dhbin.isme.repository.sherry.entity.Permission;
import lombok.Data;

/**
 * 更新权限
 */
@Data
public class UpdatePermissionRequest {

    private String name;

    private String code;

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
      permission.setKeepalive(keepAlive ? (byte) 1 : (byte) 0);
      permission.setMethod(method);
      permission.setDescription(description);
      permission.setShow(show ? (byte) 1 : (byte) 0);
      permission.setEnable(enable ? (byte) 1 : (byte) 0);
      permission.setOrder(order);
      return permission;
    }

}
