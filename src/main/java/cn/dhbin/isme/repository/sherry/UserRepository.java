package cn.dhbin.isme.repository.sherry;

import static cn.dhbin.isme.repository.SqlBuilderX.isEqualToWhenNotBlank;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;

import cn.dhbin.isme.repository.sherry.entity.User;
import cn.dhbin.isme.repository.sherry.mapper.UserDynamicSqlSupport;
import cn.dhbin.isme.repository.sherry.mapper.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  @Autowired
  private UserMapper userMapper;

  public User findByUsername(String username) {
    return userMapper.selectOne(c ->
        c.where(UserDynamicSqlSupport.username, isEqualTo(username)).limit(1)).orElse(null);
  }

  public User getById(int userId) {
    return userMapper.selectByPrimaryKey(userId).orElse(null);
  }

  public List<User> getBy(String username, Boolean enable, Integer gender) {
    return userMapper.select(c ->
        c.where(UserDynamicSqlSupport.username, isEqualToWhenNotBlank(username))
            .and(UserDynamicSqlSupport.enable, isEqualToWhenPresent(enable == null ? null : (byte) (enable ? 1 : 0)))
    );
  }

  public void removeUser(int id) {
    userMapper.deleteByPrimaryKey(id);
  }

  public boolean exists(String username) {
    return userMapper.count(c -> c.where(UserDynamicSqlSupport.username, isEqualTo(username))) > 0;
  }

  public void save(User user) {
    userMapper.insertSelective(user);
  }

  public void update(User user) {
    userMapper.updateByPrimaryKeySelective(user);
  }
}
