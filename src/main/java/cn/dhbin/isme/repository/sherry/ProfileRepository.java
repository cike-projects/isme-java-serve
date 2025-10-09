package cn.dhbin.isme.repository.sherry;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cn.dhbin.isme.repository.sherry.entity.Profile;
import cn.dhbin.isme.repository.sherry.mapper.ProfileDynamicSqlSupport;
import cn.dhbin.isme.repository.sherry.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

  @Autowired
  private ProfileMapper profileMapper;

  public Profile findByUserId(int userId) {
    return profileMapper.selectOne(c ->
        c.where(ProfileDynamicSqlSupport.userid, isEqualTo(userId)).limit(1)).orElse( null);
  }

  public void updateById(Profile profile) {
    profileMapper.updateByPrimaryKeySelective( profile);
  }

  public void save(Profile profile) {
    profileMapper.insertSelective( profile);
  }

  public void removeByUserId(int id) {
    profileMapper.delete(c -> c.where(ProfileDynamicSqlSupport.userid, isEqualTo(id)));
  }
}
