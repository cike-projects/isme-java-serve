package cn.dhbin.isme.repository.sherry.selfmapper;

import cn.dhbin.isme.repository.sherry.entity.Role;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleSelfMapper {

  @Select("select * from role where id in (select roleId from user_roles_role where userId=#{userId})")
  List<Role> findRolesByUserId(@Param("userId") int userId);
}
