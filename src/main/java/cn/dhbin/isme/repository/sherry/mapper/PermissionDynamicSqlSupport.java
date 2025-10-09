package cn.dhbin.isme.repository.sherry.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class PermissionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    public static final Permission permission = new Permission();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.id")
    public static final SqlColumn<Integer> id = permission.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.name")
    public static final SqlColumn<String> name = permission.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.code")
    public static final SqlColumn<String> code = permission.code;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.type")
    public static final SqlColumn<String> type = permission.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.parentId")
    public static final SqlColumn<Integer> parentid = permission.parentid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.path")
    public static final SqlColumn<String> path = permission.path;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.redirect")
    public static final SqlColumn<String> redirect = permission.redirect;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.icon")
    public static final SqlColumn<String> icon = permission.icon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.component")
    public static final SqlColumn<String> component = permission.component;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.layout")
    public static final SqlColumn<String> layout = permission.layout;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.keepAlive")
    public static final SqlColumn<Byte> keepalive = permission.keepalive;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.method")
    public static final SqlColumn<String> method = permission.method;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.description")
    public static final SqlColumn<String> description = permission.description;

    /**
     * Database Column Remarks:
     *   是否展示在页面菜单
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.show")
    public static final SqlColumn<Byte> show = permission.show;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.enable")
    public static final SqlColumn<Byte> enable = permission.enable;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: permission.order")
    public static final SqlColumn<Integer> order = permission.order;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    public static final class Permission extends AliasableSqlTable<Permission> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<String> type = column("`type`", JDBCType.VARCHAR);

        public final SqlColumn<Integer> parentid = column("parentId", JDBCType.INTEGER);

        public final SqlColumn<String> path = column("`path`", JDBCType.VARCHAR);

        public final SqlColumn<String> redirect = column("redirect", JDBCType.VARCHAR);

        public final SqlColumn<String> icon = column("icon", JDBCType.VARCHAR);

        public final SqlColumn<String> component = column("component", JDBCType.VARCHAR);

        public final SqlColumn<String> layout = column("layout", JDBCType.VARCHAR);

        public final SqlColumn<Byte> keepalive = column("keepAlive", JDBCType.TINYINT);

        public final SqlColumn<String> method = column("`method`", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Byte> show = column("`show`", JDBCType.TINYINT);

        public final SqlColumn<Byte> enable = column("`enable`", JDBCType.TINYINT);

        public final SqlColumn<Integer> order = column("`order`", JDBCType.INTEGER);

        public Permission() {
            super("permission", Permission::new);
        }
    }
}