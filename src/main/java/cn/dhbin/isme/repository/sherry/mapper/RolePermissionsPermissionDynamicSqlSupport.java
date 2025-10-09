package cn.dhbin.isme.repository.sherry.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class RolePermissionsPermissionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    public static final RolePermissionsPermission rolePermissionsPermission = new RolePermissionsPermission();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role_permissions_permission.roleId")
    public static final SqlColumn<Integer> roleid = rolePermissionsPermission.roleid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role_permissions_permission.permissionId")
    public static final SqlColumn<Integer> permissionid = rolePermissionsPermission.permissionid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    public static final class RolePermissionsPermission extends AliasableSqlTable<RolePermissionsPermission> {
        public final SqlColumn<Integer> roleid = column("roleId", JDBCType.INTEGER);

        public final SqlColumn<Integer> permissionid = column("permissionId", JDBCType.INTEGER);

        public RolePermissionsPermission() {
            super("role_permissions_permission", RolePermissionsPermission::new);
        }
    }
}