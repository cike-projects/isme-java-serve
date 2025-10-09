package cn.dhbin.isme.repository.sherry.mapper;

import static cn.dhbin.isme.repository.sherry.mapper.ProfileDynamicSqlSupport.address;
import static cn.dhbin.isme.repository.sherry.mapper.ProfileDynamicSqlSupport.avatar;
import static cn.dhbin.isme.repository.sherry.mapper.ProfileDynamicSqlSupport.email;
import static cn.dhbin.isme.repository.sherry.mapper.ProfileDynamicSqlSupport.gender;
import static cn.dhbin.isme.repository.sherry.mapper.ProfileDynamicSqlSupport.id;
import static cn.dhbin.isme.repository.sherry.mapper.ProfileDynamicSqlSupport.nickname;
import static cn.dhbin.isme.repository.sherry.mapper.ProfileDynamicSqlSupport.profile;
import static cn.dhbin.isme.repository.sherry.mapper.ProfileDynamicSqlSupport.userid;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cn.dhbin.isme.repository.sherry.entity.Profile;
import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ProfileMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    BasicColumn[] selectList = BasicColumn.columnList(id, gender, avatar, address, email, userid, nickname);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<Profile> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Profile> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ProfileResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="nickName", property="nickname", jdbcType=JdbcType.VARCHAR)
    })
    List<Profile> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ProfileResult")
    Optional<Profile> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, profile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, profile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default int insert(Profile row) {
        return MyBatis3Utils.insert(this::insert, row, profile, c ->
            c.map(gender).toProperty("gender")
            .map(avatar).toProperty("avatar")
            .map(address).toProperty("address")
            .map(email).toProperty("email")
            .map(userid).toProperty("userid")
            .map(nickname).toProperty("nickname")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default int insertMultiple(Collection<Profile> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, profile, c ->
            c.map(gender).toProperty("gender")
            .map(avatar).toProperty("avatar")
            .map(address).toProperty("address")
            .map(email).toProperty("email")
            .map(userid).toProperty("userid")
            .map(nickname).toProperty("nickname")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default int insertSelective(Profile row) {
        return MyBatis3Utils.insert(this::insert, row, profile, c ->
            c.map(gender).toPropertyWhenPresent("gender", row::getGender)
            .map(avatar).toPropertyWhenPresent("avatar", row::getAvatar)
            .map(address).toPropertyWhenPresent("address", row::getAddress)
            .map(email).toPropertyWhenPresent("email", row::getEmail)
            .map(userid).toPropertyWhenPresent("userid", row::getUserid)
            .map(nickname).toPropertyWhenPresent("nickname", row::getNickname)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default Optional<Profile> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, profile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default List<Profile> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, profile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default List<Profile> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, profile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default Optional<Profile> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, profile, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    static UpdateDSL<UpdateModel> updateAllColumns(Profile row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(gender).equalTo(row::getGender)
                .set(avatar).equalTo(row::getAvatar)
                .set(address).equalTo(row::getAddress)
                .set(email).equalTo(row::getEmail)
                .set(userid).equalTo(row::getUserid)
                .set(nickname).equalTo(row::getNickname);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Profile row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(gender).equalToWhenPresent(row::getGender)
                .set(avatar).equalToWhenPresent(row::getAvatar)
                .set(address).equalToWhenPresent(row::getAddress)
                .set(email).equalToWhenPresent(row::getEmail)
                .set(userid).equalToWhenPresent(row::getUserid)
                .set(nickname).equalToWhenPresent(row::getNickname);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default int updateByPrimaryKey(Profile row) {
        return update(c ->
            c.set(gender).equalTo(row::getGender)
            .set(avatar).equalTo(row::getAvatar)
            .set(address).equalTo(row::getAddress)
            .set(email).equalTo(row::getEmail)
            .set(userid).equalTo(row::getUserid)
            .set(nickname).equalTo(row::getNickname)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: profile")
    default int updateByPrimaryKeySelective(Profile row) {
        return update(c ->
            c.set(gender).equalToWhenPresent(row::getGender)
            .set(avatar).equalToWhenPresent(row::getAvatar)
            .set(address).equalToWhenPresent(row::getAddress)
            .set(email).equalToWhenPresent(row::getEmail)
            .set(userid).equalToWhenPresent(row::getUserid)
            .set(nickname).equalToWhenPresent(row::getNickname)
            .where(id, isEqualTo(row::getId))
        );
    }
}