package cn.dhbin.isme.repository.sherry.mapper;

import static cn.dhbin.isme.repository.sherry.mapper.RolePermissionsPermissionDynamicSqlSupport.permissionid;
import static cn.dhbin.isme.repository.sherry.mapper.RolePermissionsPermissionDynamicSqlSupport.rolePermissionsPermission;
import static cn.dhbin.isme.repository.sherry.mapper.RolePermissionsPermissionDynamicSqlSupport.roleid;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cn.dhbin.isme.repository.sherry.entity.RolePermissionsPermission;
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
public interface RolePermissionsPermissionMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<RolePermissionsPermission>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    BasicColumn[] selectList = BasicColumn.columnList(roleid, permissionid);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RolePermissionsPermissionResult", value = {
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permissionId", property="permissionid", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<RolePermissionsPermission> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RolePermissionsPermissionResult")
    Optional<RolePermissionsPermission> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, rolePermissionsPermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, rolePermissionsPermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    default int deleteByPrimaryKey(Integer roleid_, Integer permissionid_) {
        return delete(c -> 
            c.where(roleid, isEqualTo(roleid_))
            .and(permissionid, isEqualTo(permissionid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    default int insert(RolePermissionsPermission row) {
        return MyBatis3Utils.insert(this::insert, row, rolePermissionsPermission, c ->
            c.map(roleid).toProperty("roleid")
            .map(permissionid).toProperty("permissionid")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    default int insertMultiple(Collection<RolePermissionsPermission> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, rolePermissionsPermission, c ->
            c.map(roleid).toProperty("roleid")
            .map(permissionid).toProperty("permissionid")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    default int insertSelective(RolePermissionsPermission row) {
        return MyBatis3Utils.insert(this::insert, row, rolePermissionsPermission, c ->
            c.map(roleid).toPropertyWhenPresent("roleid", row::getRoleid)
            .map(permissionid).toPropertyWhenPresent("permissionid", row::getPermissionid)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    default Optional<RolePermissionsPermission> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, rolePermissionsPermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    default List<RolePermissionsPermission> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, rolePermissionsPermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    default List<RolePermissionsPermission> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, rolePermissionsPermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, rolePermissionsPermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    static UpdateDSL<UpdateModel> updateAllColumns(RolePermissionsPermission row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roleid).equalTo(row::getRoleid)
                .set(permissionid).equalTo(row::getPermissionid);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_permissions_permission")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RolePermissionsPermission row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roleid).equalToWhenPresent(row::getRoleid)
                .set(permissionid).equalToWhenPresent(row::getPermissionid);
    }
}