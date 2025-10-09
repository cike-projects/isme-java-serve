package cn.dhbin.isme.pms.controller;

import cn.dhbin.isme.common.auth.RoleType;
import cn.dhbin.isme.common.auth.Roles;
import cn.dhbin.isme.common.response.PageList;
import cn.dhbin.isme.common.response.R;
import cn.dhbin.isme.pms.domain.dto.PermissionDto;
import cn.dhbin.isme.pms.domain.dto.RoleDto;
import cn.dhbin.isme.pms.domain.dto.RolePageDto;
import cn.dhbin.isme.pms.domain.request.AddRolePermissionsRequest;
import cn.dhbin.isme.pms.domain.request.AddRoleUsersRequest;
import cn.dhbin.isme.pms.domain.request.CreateRoleRequest;
import cn.dhbin.isme.pms.domain.request.RemoveRoleUsersRequest;
import cn.dhbin.isme.pms.domain.request.RolePageRequest;
import cn.dhbin.isme.pms.domain.request.UpdateRoleRequest;
import cn.dhbin.isme.pms.service.RoleService;
import cn.dhbin.isme.repository.sherry.entity.Role;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色Controller
 */
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

  private final RoleService roleService;

  /**
   * 新建角色
   *
   * @return R
   */
  @PostMapping
  @Roles(RoleType.SUPER_ADMIN)
  public R<Void> create(@RequestBody @Validated CreateRoleRequest request) {
    roleService.createRole(request);
    return R.ok();
  }

  @GetMapping
  public R<List<RoleDto>> findAll(@RequestParam(value = "enable", required = false) Boolean enable) {
    List<RoleDto> roleDtoList = roleService.getBy(enable);
    return R.ok(roleDtoList);
  }

  /**
   * 分页
   *
   * @return R
   */
  @GetMapping("/page")
  public R<PageList<RolePageDto>> findPagination(RolePageRequest request) {
    PageList<RolePageDto> ret = roleService.queryPage(request);
    return R.ok(ret);
  }

  /**
   * 查询角色权限
   *
   * @return R
   */
  @GetMapping("/permissions")
  public R<List<PermissionDto>> findRolePermissions(int id) {
    List<PermissionDto> permissionDtoList = roleService.findRolePermissions(id);
    return R.ok(permissionDtoList);
  }


  /**
   * 根据id获取
   *
   * @return R
   */
  @GetMapping("{id}")
  @Roles(RoleType.SUPER_ADMIN)
  public R<RoleDto> findOne(@PathVariable int id) {
    Role role = roleService.getById(id);
    return R.ok(RoleService.toDto(role));
  }


  /**
   * 根据id更新
   *
   * @return R
   */
  @PatchMapping("{id}")
  @Roles({RoleType.SUPER_ADMIN, RoleType.SYS_ADMIN, RoleType.ROLE_PMS})
  public R<Void> update(@PathVariable int id, @RequestBody UpdateRoleRequest request) {
    roleService.updateRole(id, request);
    return R.ok();
  }


  /**
   * 根据id删除
   *
   * @return R
   */
  @DeleteMapping("{id}")
  @Roles({RoleType.SUPER_ADMIN})
  public R<Void> remove(@PathVariable int id) {
    roleService.removeRole(id);
    return R.ok();
  }


  /**
   * 给角色添加权限
   *
   * @return R
   */
  @PostMapping("/permissions/add")
  @Roles({RoleType.SUPER_ADMIN})
  public R<Void> addRolePermissions(@RequestBody @Validated AddRolePermissionsRequest request) {
    roleService.addRolePermissions(request);
    return R.ok();
  }

  /**
   * 角色的权限树
   *
   * @return R
   */
  @GetMapping("/permissions/tree")
  public R<List<Tree<Integer>>> permissionTree() {
    List<Tree<Integer>> treeList = roleService.findRolePermissionsTree("SUPER_ADMIN");
    return R.ok(treeList);
  }


  /**
   * 给角色分配用户
   *
   * @return R
   */
  @PatchMapping("/users/add/{roleId}")
  @Roles({RoleType.SUPER_ADMIN})
  public R<Void> addRoleUsers(@PathVariable int roleId, @RequestBody AddRoleUsersRequest request) {
    roleService.addRoleUsers(roleId, request);
    return R.ok();
  }


  @PatchMapping("/users/remove/{roleId}")
  @Roles({RoleType.SUPER_ADMIN})
  public R<Void> removeRoleUsers(@PathVariable int roleId, @RequestBody RemoveRoleUsersRequest request) {
    roleService.removeRoleUsers(roleId, request);
    return R.ok();
  }
}
