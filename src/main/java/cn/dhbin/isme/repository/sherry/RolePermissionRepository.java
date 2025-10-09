package cn.dhbin.isme.repository.sherry;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cn.dhbin.isme.repository.sherry.entity.RolePermissionsPermission;
import cn.dhbin.isme.repository.sherry.mapper.RolePermissionsPermissionDynamicSqlSupport;
import cn.dhbin.isme.repository.sherry.mapper.RolePermissionsPermissionMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RolePermissionRepository {

  private final RolePermissionsPermissionMapper rolePermissionsPermissionMapper;

  public void saveBatch(List<RolePermissionsPermission> permissionList) {
    rolePermissionsPermissionMapper.insertMultiple(permissionList);
  }

  public List<Integer> getPermissionIdByRoRoleId(Integer id) {
    return rolePermissionsPermissionMapper.select(c ->
        c.where(RolePermissionsPermissionDynamicSqlSupport.roleid, isEqualTo(id)))
        .stream()
        .map(RolePermissionsPermission::getPermissionid)
        .toList();
  }

  public void deleteByRoleId(int roleId) {
    rolePermissionsPermissionMapper.delete(c -> c.where(RolePermissionsPermissionDynamicSqlSupport.roleid, isEqualTo(roleId)));
  }
}
