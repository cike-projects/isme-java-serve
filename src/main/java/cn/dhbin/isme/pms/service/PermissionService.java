package cn.dhbin.isme.pms.service;

import cn.dhbin.isme.pms.domain.dto.PermissionDto;
import cn.dhbin.isme.pms.domain.request.CreatePermissionRequest;
import cn.dhbin.isme.pms.util.ConvertUtil;
import cn.dhbin.isme.pms.util.PermissionUtil;
import cn.dhbin.isme.repository.sherry.PermissionRepository;
import cn.dhbin.isme.repository.sherry.entity.Permission;
import cn.hutool.core.lang.tree.Tree;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 权限服务类的实现类，主要负责权限相关的处理
 *
 * @author dhb
 */
@Service
public class PermissionService {

  public static PermissionDto toDto(Permission it) {
    return new PermissionDto()
        .setId(it.getId())
        .setName(it.getName())
        .setCode(it.getCode())
        .setType(it.getType())
        .setParentId(it.getParentid())
        .setPath(it.getPath())
        .setRedirect(it.getRedirect())
        .setIcon(it.getIcon())
        .setComponent(it.getComponent())
        .setLayout(it.getLayout())
        .setKeepAlive(it.getKeepalive() != null && it.getKeepalive() == 1)
        .setMethod(it.getMethod())
        .setDescription(it.getDescription())
        .setShow(it.getShow() == 1)
        .setEnable(it.getEnable() == 1)
        .setOrder(it.getOrder());
  }

  private static final String TYPE_MENU = "MENU";
  private static final String TYPE_BUTTON = "BUTTON";

  @Autowired
  private PermissionRepository permissionRepository;
  public List<Permission> findByRoleId(int roleId) {
    return permissionRepository.findByRoleId(roleId);
  }


  public void create(CreatePermissionRequest request) {
    Permission permission = new Permission();
    permission.setName(request.getName());
    permission.setCode(request.getCode());
    permission.setType(request.getType());
    permission.setParentid(request.getParentId());
    permission.setPath(request.getPath());
    permission.setRedirect(request.getRedirect());
    permission.setIcon(request.getIcon());
    permission.setComponent(request.getComponent());
    permission.setLayout(request.getLayout());
    permission.setKeepalive(ConvertUtil.toByte(request.getKeepAlive()));
    permission.setMethod(request.getMethod());
    permission.setDescription(request.getDescription());
    permission.setShow(ConvertUtil.toByte(request.getShow()));
    permission.setEnable(ConvertUtil.toByte(request.getEnable()));
    permission.setOrder(request.getOrder());
    permissionRepository.save(permission);
  }

  
  @Transactional(rollbackFor = Exception.class)
  public void createBatch(List<CreatePermissionRequest> request) {
    List<Permission> list = request.stream().map(CreatePermissionRequest::convert).toList();
    this.saveBatch(list);
  }

  private void saveBatch(List<Permission> list) {
    permissionRepository.saveBatch(list);
  }


  public List<PermissionDto> findAllMenu() {
    return permissionRepository.getByType(TYPE_MENU)
        .stream()
        .map(PermissionService::toDto)
        .toList();
  }

  
  public List<Tree<Integer>> findAllMenuTree() {
    List<Permission> permissions = permissionRepository.getByType(TYPE_MENU);
    List<PermissionDto> permissionDtos = permissions.stream().map(PermissionService::toDto).toList();

    return PermissionUtil.toTreeNode(permissionDtos, null);
  }

  
  public List<Tree<Integer>> findAllTree() {
    List<Permission> permissions = permissionRepository.all();
    List<PermissionDto> permissionDtos = permissions.stream().map(PermissionService::toDto).toList();
    return PermissionUtil.toTreeNode(permissionDtos, null);
  }

  
  public List<Permission> findButton(Integer parentId) {
    return permissionRepository.getByParentIdAndType(parentId, TYPE_BUTTON);
  }

  
  public boolean validateMenuPath(String path) {
    return permissionRepository.countByPath(path) > 0;
  }

  
  public List<Permission> list() {
    return permissionRepository.all();
  }

  public Permission getById(int id) {
    return permissionRepository.getById(id);
  }

  public void updateById(Permission permission) {
    permissionRepository.updateById(permission);
  }

  public void removeById(int id) {
    permissionRepository.removeById(id);
  }
}
