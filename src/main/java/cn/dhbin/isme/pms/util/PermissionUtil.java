package cn.dhbin.isme.pms.util;

import cn.dhbin.isme.pms.domain.dto.PermissionDto;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import java.util.List;
import lombok.experimental.UtilityClass;

/**
 * 权限相关工具类
 *
 * @author dhb
 */
@UtilityClass
public class PermissionUtil {

  public List<Tree<Integer>> toTreeNode(List<PermissionDto> permissions, Integer parent) {
    List<TreeNode<Integer>> nodes = permissions.stream().map(permission -> {
      TreeNode<Integer> treeNode = new TreeNode<>();
      treeNode.setId(permission.getId());
      treeNode.setParentId(permission.getParentId());
      treeNode.setWeight(permission.getOrder());
      treeNode.setName(permission.getName());
      treeNode.setExtra(BeanUtil.beanToMap(permission));
      return treeNode;
    }).toList();
    return TreeUtil.build(nodes, parent);
  }
}

