package cn.dhbin.isme.pms.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 权限
 *
 * @author dhb
 */
@Data
@Accessors(chain = true)
public class PermissionDto {

    private int id;

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

}
