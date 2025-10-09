package cn.dhbin.isme.pms.controller;

import cn.dhbin.isme.common.preview.Preview;
import cn.dhbin.isme.common.response.R;
import cn.dhbin.isme.pms.domain.dto.PermissionDto;
import cn.dhbin.isme.pms.domain.request.CreatePermissionRequest;
import cn.dhbin.isme.pms.domain.request.UpdatePermissionRequest;
import cn.dhbin.isme.pms.service.PermissionService;
import cn.dhbin.isme.repository.sherry.entity.Permission;
import cn.hutool.core.lang.tree.Tree;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限Controller
 *
 * @author dhb
 */
@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
public class PermissionController {


  private final PermissionService permissionService;

  /**
   * 新建权限
   *
   * @return R
   */
  @PostMapping
  @Preview
  public R<Void> create(@RequestBody @Validated CreatePermissionRequest request) {
    permissionService.create(request);
    return R.ok();
  }


  /**
   * 批量创建权限
   *
   * @return R
   */
  @PostMapping("/batch")
  @Preview
  public R<Void> batchCreate(@RequestBody @Validated List<CreatePermissionRequest> request) {
    permissionService.createBatch(request);
    return R.ok();
  }

  /**
   * 获取所有权限
   *
   * @return R
   */
  @GetMapping
  public R<List<PermissionDto>> findAll() {
    List<PermissionDto> menu = permissionService.findAllMenu();
    return R.ok(menu);
  }

  /**
   * 获取所有权限树
   *
   * @return R
   */
  @GetMapping("/tree")
  public R<List<Tree<Integer>>> findAllTree() {
    List<Tree<Integer>> tree = permissionService.findAllTree();
    return R.ok(tree);
  }

  /**
   * 获取菜单树
   *
   * @return R
   */
  @GetMapping("menu/tree")
  public R<List<Tree<Integer>>> findMenuTree() {
    List<Tree<Integer>> tree = permissionService.findAllMenuTree();
    return R.ok(tree);
  }

  /**
   * 根据id获取
   *
   * @return R
   */
  @GetMapping("{id}")
  public R<PermissionDto> findOne(@PathVariable int id) {
    Permission permission = permissionService.getById(id);
    return R.ok(PermissionService.toDto(permission));
  }

  /**
   * 根据id更新
   *
   * @return R
   */
  @PatchMapping("{id}")
  public R<Object> update(@PathVariable int id, @RequestBody UpdatePermissionRequest request) {
    Permission permission = request.convert();
    permission.setId(id);
    permissionService.updateById(permission);
    return R.ok();
  }

  /**
   * 根据id删除
   *
   * @return R
   */
  @DeleteMapping("{id}")
  public R<Object> remove(@PathVariable int id) {
    permissionService.removeById(id);
    return R.ok();
  }


  /**
   * 获取
   *
   * @return R
   */
  @GetMapping("/button/{parentId}")
  public R<List<PermissionDto>> findButtonAndApi(@PathVariable Integer parentId) {
    List<PermissionDto> permissions = permissionService.findButton(parentId)
        .stream()
        .map(PermissionService::toDto)
        .toList();
    return R.ok(permissions);
  }

  /**
   * 校验 path 存不存在menu资源内
   *
   * @return R
   */
  @GetMapping("/menu/validate")
  public R<Object> validateMenuPath(String path) {
    boolean b = permissionService.validateMenuPath(path);
    return R.ok(b);
  }

}
