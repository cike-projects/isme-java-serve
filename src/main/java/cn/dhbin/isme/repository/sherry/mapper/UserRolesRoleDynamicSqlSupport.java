package cn.dhbin.isme.repository.sherry.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UserRolesRoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    public static final UserRolesRole userRolesRole = new UserRolesRole();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_roles_role.userId")
    public static final SqlColumn<Integer> userid = userRolesRole.userid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_roles_role.roleId")
    public static final SqlColumn<Integer> roleid = userRolesRole.roleid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    public static final class UserRolesRole extends AliasableSqlTable<UserRolesRole> {
        public final SqlColumn<Integer> userid = column("userId", JDBCType.INTEGER);

        public final SqlColumn<Integer> roleid = column("roleId", JDBCType.INTEGER);

        public UserRolesRole() {
            super("user_roles_role", UserRolesRole::new);
        }
    }
}