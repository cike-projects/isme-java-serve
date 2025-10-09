package cn.dhbin.isme.repository.sherry.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ProfileDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    public static final Profile profile = new Profile();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: profile.id")
    public static final SqlColumn<Integer> id = profile.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: profile.gender")
    public static final SqlColumn<Integer> gender = profile.gender;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: profile.avatar")
    public static final SqlColumn<String> avatar = profile.avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: profile.address")
    public static final SqlColumn<String> address = profile.address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: profile.email")
    public static final SqlColumn<String> email = profile.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: profile.userId")
    public static final SqlColumn<Integer> userid = profile.userid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: profile.nickName")
    public static final SqlColumn<String> nickname = profile.nickname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    public static final class Profile extends AliasableSqlTable<Profile> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> gender = column("gender", JDBCType.INTEGER);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Integer> userid = column("userId", JDBCType.INTEGER);

        public final SqlColumn<String> nickname = column("nickName", JDBCType.VARCHAR);

        public Profile() {
            super("profile", Profile::new);
        }
    }
}