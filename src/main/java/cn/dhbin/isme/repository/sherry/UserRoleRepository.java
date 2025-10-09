package cn.dhbin.isme.repository.sherry;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isIn;

import cn.dhbin.isme.repository.sherry.entity.UserRolesRole;
import cn.dhbin.isme.repository.sherry.mapper.UserRolesRoleDynamicSqlSupport;
import cn.dhbin.isme.repository.sherry.mapper.UserRolesRoleMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleRepository {

  @Autowired
  private UserRolesRoleMapper userRolesRoleMapper;


  public void deleteByRoleIdAndUserIds(int roleId, List<Integer> userIds) {
    userRolesRoleMapper.delete( c -> c.where()
        .and(UserRolesRoleDynamicSqlSupport.roleid, isEqualTo(roleId))
        .and(UserRolesRoleDynamicSqlSupport.userid, isIn(userIds))
    );
  }

  public void saveBatch(List<UserRolesRole> permissionList) {
    userRolesRoleMapper.insertMultiple(permissionList);
  }

  public List<Integer> getAllUserIdByRoleId(int roleId) {
    return userRolesRoleMapper.select(c ->
        c.where(UserRolesRoleDynamicSqlSupport.roleid, isEqualTo(roleId)))
        .stream()
        .map(UserRolesRole::getUserid)
        .toList();
  }

  public void deleteByRoleId(int roleId) {
    userRolesRoleMapper.delete(c -> c.where(UserRolesRoleDynamicSqlSupport.roleid, isEqualTo(roleId)));
  }

  public void deleteByUserId(int userId) {
    userRolesRoleMapper.delete(c -> c.where(UserRolesRoleDynamicSqlSupport.userid, isEqualTo(userId)));
  }
}
