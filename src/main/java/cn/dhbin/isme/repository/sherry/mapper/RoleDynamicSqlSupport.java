package cn.dhbin.isme.repository.sherry.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class RoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    public static final Role role = new Role();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role.id")
    public static final SqlColumn<Integer> id = role.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role.code")
    public static final SqlColumn<String> code = role.code;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role.name")
    public static final SqlColumn<String> name = role.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role.enable")
    public static final SqlColumn<Byte> enable = role.enable;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    public static final class Role extends AliasableSqlTable<Role> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<Byte> enable = column("`enable`", JDBCType.TINYINT);

        public Role() {
            super("role", Role::new);
        }
    }
}