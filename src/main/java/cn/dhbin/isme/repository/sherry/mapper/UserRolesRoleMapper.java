package cn.dhbin.isme.repository.sherry.mapper;

import static cn.dhbin.isme.repository.sherry.mapper.UserRolesRoleDynamicSqlSupport.roleid;
import static cn.dhbin.isme.repository.sherry.mapper.UserRolesRoleDynamicSqlSupport.userRolesRole;
import static cn.dhbin.isme.repository.sherry.mapper.UserRolesRoleDynamicSqlSupport.userid;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cn.dhbin.isme.repository.sherry.entity.UserRolesRole;
import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface UserRolesRoleMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UserRolesRole>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    BasicColumn[] selectList = BasicColumn.columnList(userid, roleid);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserRolesRoleResult", value = {
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<UserRolesRole> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserRolesRoleResult")
    Optional<UserRolesRole> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userRolesRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userRolesRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    default int deleteByPrimaryKey(Integer userid_, Integer roleid_) {
        return delete(c -> 
            c.where(userid, isEqualTo(userid_))
            .and(roleid, isEqualTo(roleid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    default int insert(UserRolesRole row) {
        return MyBatis3Utils.insert(this::insert, row, userRolesRole, c ->
            c.map(userid).toProperty("userid")
            .map(roleid).toProperty("roleid")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    default int insertMultiple(Collection<UserRolesRole> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, userRolesRole, c ->
            c.map(userid).toProperty("userid")
            .map(roleid).toProperty("roleid")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    default int insertSelective(UserRolesRole row) {
        return MyBatis3Utils.insert(this::insert, row, userRolesRole, c ->
            c.map(userid).toPropertyWhenPresent("userid", row::getUserid)
            .map(roleid).toPropertyWhenPresent("roleid", row::getRoleid)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    default Optional<UserRolesRole> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userRolesRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    default List<UserRolesRole> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userRolesRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    default List<UserRolesRole> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userRolesRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userRolesRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    static UpdateDSL<UpdateModel> updateAllColumns(UserRolesRole row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userid).equalTo(row::getUserid)
                .set(roleid).equalTo(row::getRoleid);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_roles_role")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserRolesRole row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userid).equalToWhenPresent(row::getUserid)
                .set(roleid).equalToWhenPresent(row::getRoleid);
    }
}