package cn.dhbin.isme.repository.sherry.mapper;

import static cn.dhbin.isme.repository.sherry.mapper.RoleDynamicSqlSupport.code;
import static cn.dhbin.isme.repository.sherry.mapper.RoleDynamicSqlSupport.enable;
import static cn.dhbin.isme.repository.sherry.mapper.RoleDynamicSqlSupport.id;
import static cn.dhbin.isme.repository.sherry.mapper.RoleDynamicSqlSupport.name;
import static cn.dhbin.isme.repository.sherry.mapper.RoleDynamicSqlSupport.role;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cn.dhbin.isme.repository.sherry.entity.Role;
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
public interface RoleMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    BasicColumn[] selectList = BasicColumn.columnList(id, code, name, enable);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<Role> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Role> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RoleResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="enable", property="enable", jdbcType=JdbcType.TINYINT)
    })
    List<Role> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RoleResult")
    Optional<Role> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default int insert(Role row) {
        return MyBatis3Utils.insert(this::insert, row, role, c ->
            c.map(code).toProperty("code")
            .map(name).toProperty("name")
            .map(enable).toProperty("enable")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default int insertMultiple(Collection<Role> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, role, c ->
            c.map(code).toProperty("code")
            .map(name).toProperty("name")
            .map(enable).toProperty("enable")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default int insertSelective(Role row) {
        return MyBatis3Utils.insert(this::insert, row, role, c ->
            c.map(code).toPropertyWhenPresent("code", row::getCode)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(enable).toPropertyWhenPresent("enable", row::getEnable)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default Optional<Role> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default List<Role> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default List<Role> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default Optional<Role> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    static UpdateDSL<UpdateModel> updateAllColumns(Role row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(code).equalTo(row::getCode)
                .set(name).equalTo(row::getName)
                .set(enable).equalTo(row::getEnable);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Role row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(code).equalToWhenPresent(row::getCode)
                .set(name).equalToWhenPresent(row::getName)
                .set(enable).equalToWhenPresent(row::getEnable);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default int updateByPrimaryKey(Role row) {
        return update(c ->
            c.set(code).equalTo(row::getCode)
            .set(name).equalTo(row::getName)
            .set(enable).equalTo(row::getEnable)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    default int updateByPrimaryKeySelective(Role row) {
        return update(c ->
            c.set(code).equalToWhenPresent(row::getCode)
            .set(name).equalToWhenPresent(row::getName)
            .set(enable).equalToWhenPresent(row::getEnable)
            .where(id, isEqualTo(row::getId))
        );
    }
}