package cn.dhbin.isme.repository.sherry.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final User user = new User();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.id")
    public static final SqlColumn<Integer> id = user.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.username")
    public static final SqlColumn<String> username = user.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.password")
    public static final SqlColumn<String> password = user.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.enable")
    public static final SqlColumn<Byte> enable = user.enable;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.createTime")
    public static final SqlColumn<LocalDateTime> createtime = user.createtime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.updateTime")
    public static final SqlColumn<LocalDateTime> updatetime = user.updatetime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final class User extends AliasableSqlTable<User> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("`password`", JDBCType.VARCHAR);

        public final SqlColumn<Byte> enable = column("`enable`", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> createtime = column("createTime", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updatetime = column("updateTime", JDBCType.TIMESTAMP);

        public User() {
            super("user", User::new);
        }
    }
}