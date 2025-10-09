package cn.dhbin.isme.pms.service;

import cn.dhbin.isme.repository.sherry.ProfileRepository;
import cn.dhbin.isme.repository.sherry.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProfileService
 *
 * @author dhb
 */
@Service
public class ProfileService {

  @Autowired
  private ProfileRepository profileRepository;


  public Profile findByUserId(int userId) {
    return profileRepository.findByUserId(userId);
  }

  public void updateById(Profile profile) {
    profileRepository.updateById(profile);
  }

  public void save(Profile profile) {
    profileRepository.save(profile);
  }

  public void removeByUserId(int id) {
    profileRepository.removeByUserId(id);
  }
}
