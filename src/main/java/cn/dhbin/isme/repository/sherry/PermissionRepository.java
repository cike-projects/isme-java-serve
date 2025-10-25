package cn.dhbin.isme.repository.sherry;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cn.dhbin.isme.repository.sherry.entity.Permission;
import cn.dhbin.isme.repository.sherry.mapper.PermissionDynamicSqlSupport;
import cn.dhbin.isme.repository.sherry.mapper.PermissionMapper;
import cn.dhbin.isme.repository.sherry.selfmapper.PermissionSelfMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PermissionRepository {

  @Autowired
  private PermissionMapper permissionMapper;

  @Autowired
  private PermissionSelfMapper permissionSelfMapper;

  public List<Permission> findByRoleId(Integer roleId) {
    return permissionSelfMapper.findByRoleId(roleId);
  }

  public List<Permission> all() {
    return permissionMapper.select(c -> c);
  }

  public List<Permission> getByType(String type) {
    return permissionMapper.select(c ->
        c.where(PermissionDynamicSqlSupport.type, isEqualTo(type))
            .orderBy(PermissionDynamicSqlSupport.order)
    );
  }

  public List<Permission> getByParentIdAndType(Integer parentId, String type) {
    return permissionMapper.select(c ->
        c.where(PermissionDynamicSqlSupport.type, isEqualTo(type))
            .and(PermissionDynamicSqlSupport.parentid, isEqualTo(parentId))
            .orderBy(PermissionDynamicSqlSupport.order)
    );
  }

  public void save(Permission permission) {
    permissionMapper.insertSelective(permission);
  }

  public Permission getById(int id) {
    return permissionMapper.selectByPrimaryKey( id).orElse(null);
  }

  public void updateById(Permission permission) {
    permissionMapper.updateByPrimaryKeySelective(permission);
  }

  public void removeById(int id) {
    permissionMapper.deleteByPrimaryKey(id);
  }

  public void saveBatch(List<Permission> list) {
    permissionMapper.insertMultiple(list);
  }

  public long countByPath(String path) {
    return permissionMapper.count(c -> c.where(PermissionDynamicSqlSupport.path, isEqualTo(path)));
  }
}
