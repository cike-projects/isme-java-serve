package cn.dhbin.isme.repository.sherry.selfmapper;

import cn.dhbin.isme.repository.sherry.entity.Permission;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PermissionSelfMapper {

  @Select("select * from permission p where p.id in (select rpp.permissionId from role_permissions_permission rpp where rpp.roleId = #{roleId})")
  List<Permission> findByRoleId(@Param("roleId") Integer roleId);
}
