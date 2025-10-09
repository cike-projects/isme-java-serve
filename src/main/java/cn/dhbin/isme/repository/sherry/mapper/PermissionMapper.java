package cn.dhbin.isme.repository.sherry.mapper;

import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.code;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.component;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.description;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.enable;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.icon;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.id;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.keepalive;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.layout;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.method;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.name;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.order;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.parentid;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.path;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.permission;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.redirect;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.show;
import static cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport.type;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cn.dhbin.isme.repository.sherry.entity.Permission;
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
public interface PermissionMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, code, type, parentid, path, redirect, icon, component, layout, keepalive, method, description, show, enable, order);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<Permission> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Permission> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PermissionResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentId", property="parentid", jdbcType=JdbcType.INTEGER),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="redirect", property="redirect", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="component", property="component", jdbcType=JdbcType.VARCHAR),
        @Result(column="layout", property="layout", jdbcType=JdbcType.VARCHAR),
        @Result(column="keepAlive", property="keepalive", jdbcType=JdbcType.TINYINT),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="show", property="show", jdbcType=JdbcType.TINYINT),
        @Result(column="enable", property="enable", jdbcType=JdbcType.TINYINT),
        @Result(column="order", property="order", jdbcType=JdbcType.INTEGER)
    })
    List<Permission> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PermissionResult")
    Optional<Permission> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default int insert(Permission row) {
        return MyBatis3Utils.insert(this::insert, row, permission, c ->
            c.map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(type).toProperty("type")
            .map(parentid).toProperty("parentid")
            .map(path).toProperty("path")
            .map(redirect).toProperty("redirect")
            .map(icon).toProperty("icon")
            .map(component).toProperty("component")
            .map(layout).toProperty("layout")
            .map(keepalive).toProperty("keepalive")
            .map(method).toProperty("method")
            .map(description).toProperty("description")
            .map(show).toProperty("show")
            .map(enable).toProperty("enable")
            .map(order).toProperty("order")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default int insertMultiple(Collection<Permission> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, permission, c ->
            c.map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(type).toProperty("type")
            .map(parentid).toProperty("parentid")
            .map(path).toProperty("path")
            .map(redirect).toProperty("redirect")
            .map(icon).toProperty("icon")
            .map(component).toProperty("component")
            .map(layout).toProperty("layout")
            .map(keepalive).toProperty("keepalive")
            .map(method).toProperty("method")
            .map(description).toProperty("description")
            .map(show).toProperty("show")
            .map(enable).toProperty("enable")
            .map(order).toProperty("order")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default int insertSelective(Permission row) {
        return MyBatis3Utils.insert(this::insert, row, permission, c ->
            c.map(name).toPropertyWhenPresent("name", row::getName)
            .map(code).toPropertyWhenPresent("code", row::getCode)
            .map(type).toPropertyWhenPresent("type", row::getType)
            .map(parentid).toPropertyWhenPresent("parentid", row::getParentid)
            .map(path).toPropertyWhenPresent("path", row::getPath)
            .map(redirect).toPropertyWhenPresent("redirect", row::getRedirect)
            .map(icon).toPropertyWhenPresent("icon", row::getIcon)
            .map(component).toPropertyWhenPresent("component", row::getComponent)
            .map(layout).toPropertyWhenPresent("layout", row::getLayout)
            .map(keepalive).toPropertyWhenPresent("keepalive", row::getKeepalive)
            .map(method).toPropertyWhenPresent("method", row::getMethod)
            .map(description).toPropertyWhenPresent("description", row::getDescription)
            .map(show).toPropertyWhenPresent("show", row::getShow)
            .map(enable).toPropertyWhenPresent("enable", row::getEnable)
            .map(order).toPropertyWhenPresent("order", row::getOrder)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default Optional<Permission> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default List<Permission> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default List<Permission> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default Optional<Permission> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    static UpdateDSL<UpdateModel> updateAllColumns(Permission row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(row::getName)
                .set(code).equalTo(row::getCode)
                .set(type).equalTo(row::getType)
                .set(parentid).equalTo(row::getParentid)
                .set(path).equalTo(row::getPath)
                .set(redirect).equalTo(row::getRedirect)
                .set(icon).equalTo(row::getIcon)
                .set(component).equalTo(row::getComponent)
                .set(layout).equalTo(row::getLayout)
                .set(keepalive).equalTo(row::getKeepalive)
                .set(method).equalTo(row::getMethod)
                .set(description).equalTo(row::getDescription)
                .set(show).equalTo(row::getShow)
                .set(enable).equalTo(row::getEnable)
                .set(order).equalTo(row::getOrder);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Permission row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(row::getName)
                .set(code).equalToWhenPresent(row::getCode)
                .set(type).equalToWhenPresent(row::getType)
                .set(parentid).equalToWhenPresent(row::getParentid)
                .set(path).equalToWhenPresent(row::getPath)
                .set(redirect).equalToWhenPresent(row::getRedirect)
                .set(icon).equalToWhenPresent(row::getIcon)
                .set(component).equalToWhenPresent(row::getComponent)
                .set(layout).equalToWhenPresent(row::getLayout)
                .set(keepalive).equalToWhenPresent(row::getKeepalive)
                .set(method).equalToWhenPresent(row::getMethod)
                .set(description).equalToWhenPresent(row::getDescription)
                .set(show).equalToWhenPresent(row::getShow)
                .set(enable).equalToWhenPresent(row::getEnable)
                .set(order).equalToWhenPresent(row::getOrder);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default int updateByPrimaryKey(Permission row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(code).equalTo(row::getCode)
            .set(type).equalTo(row::getType)
            .set(parentid).equalTo(row::getParentid)
            .set(path).equalTo(row::getPath)
            .set(redirect).equalTo(row::getRedirect)
            .set(icon).equalTo(row::getIcon)
            .set(component).equalTo(row::getComponent)
            .set(layout).equalTo(row::getLayout)
            .set(keepalive).equalTo(row::getKeepalive)
            .set(method).equalTo(row::getMethod)
            .set(description).equalTo(row::getDescription)
            .set(show).equalTo(row::getShow)
            .set(enable).equalTo(row::getEnable)
            .set(order).equalTo(row::getOrder)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: permission")
    default int updateByPrimaryKeySelective(Permission row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(code).equalToWhenPresent(row::getCode)
            .set(type).equalToWhenPresent(row::getType)
            .set(parentid).equalToWhenPresent(row::getParentid)
            .set(path).equalToWhenPresent(row::getPath)
            .set(redirect).equalToWhenPresent(row::getRedirect)
            .set(icon).equalToWhenPresent(row::getIcon)
            .set(component).equalToWhenPresent(row::getComponent)
            .set(layout).equalToWhenPresent(row::getLayout)
            .set(keepalive).equalToWhenPresent(row::getKeepalive)
            .set(method).equalToWhenPresent(row::getMethod)
            .set(description).equalToWhenPresent(row::getDescription)
            .set(show).equalToWhenPresent(row::getShow)
            .set(enable).equalToWhenPresent(row::getEnable)
            .set(order).equalToWhenPresent(row::getOrder)
            .where(id, isEqualTo(row::getId))
        );
    }
}