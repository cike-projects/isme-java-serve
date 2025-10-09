package cn.dhbin.isme.repository.sherry;

import static cn.dhbin.isme.repository.SqlBuilderX.isEqualToWhenNotBlank;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;
import static org.mybatis.dynamic.sql.SqlBuilder.or;

import cn.dhbin.isme.repository.sherry.entity.Role;
import cn.dhbin.isme.repository.sherry.mapper.RoleDynamicSqlSupport;
import cn.dhbin.isme.repository.sherry.mapper.RoleMapper;
import cn.dhbin.isme.repository.sherry.selfmapper.RoleSelfMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {

  @Autowired
  private RoleMapper roleMapper;

  @Autowired
  private RoleSelfMapper roleSelfMapper;

  public List<Role> findRolesByUserId(int userId) {
    return roleSelfMapper.findRolesByUserId(userId);
  }

  public Role findByCode(String roleCode) {
    return roleMapper.selectOne(c -> c.where(RoleDynamicSqlSupport.code, isEqualTo(roleCode)).limit(1)).orElse(null);
  }

  public List<Role> getByNameAndEnable(String name, Boolean enable) {
    return roleMapper.select(c ->
        c.where(RoleDynamicSqlSupport.enable, isEqualToWhenPresent(enable == null ? null : (byte) (enable ? 1 : 0)))
            .and(RoleDynamicSqlSupport.name, isEqualToWhenNotBlank(name))
    );
  }

  public Role getById(int id) {
    return roleMapper.selectByPrimaryKey( id).orElse( null);
  }

  public void deleteById(int id) {
    roleMapper.deleteByPrimaryKey(id);
  }

  public void updateById(Role role) {
    roleMapper.updateByPrimaryKey(role);
  }

  public boolean existsByCodeOrName(String code, String name) {
    return roleMapper.count(c ->
        c.where(RoleDynamicSqlSupport.code, isEqualToWhenNotBlank(code))
        .or(RoleDynamicSqlSupport.name, isEqualToWhenNotBlank(name))
    ) > 0;
  }

  public List<Role> findByCodeOrName(String code, String name) {
    return roleMapper.select(c ->
        c.where(RoleDynamicSqlSupport.code, isEqualToWhenNotBlank(code),
            or(RoleDynamicSqlSupport.name, isEqualToWhenNotBlank(name)))
    );
  }

  public void save(Role role) {
    roleMapper.insertSelective(role);
  }
}
