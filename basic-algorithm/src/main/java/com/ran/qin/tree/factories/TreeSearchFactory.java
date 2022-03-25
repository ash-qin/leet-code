/**
 * @Classname TreeSearchFactory
 * @Description 二叉树查询工厂
 * @Date 2022/3/22 9:10 下午
 * @author zhangqin
 */

package com.ran.qin.tree.factories;

import com.ran.qin.tree.model.TreeNode;

import java.util.List;

public interface TreeSearchFactory<T> {

    /**
     * 树的先序便利 ---- 递归
     * @param root 树
     * @return 先序遍历的所有节点
     */
    List<T> preOrderTraverse(TreeNode<T> root);

    /**
     * 树的中序遍历 ---- 递归
     * @param root 树
     * @return 中序遍历的所有节点
     */
    List<T> inOrderTraverse(TreeNode<T> root);

    /**
     * 树的后序遍历 ---- 递归
     * @param root 树
     * @return 后序遍历的所有节点
     */
    List<T> postOrderTraverse(TreeNode<T> root);

    /**
     * 树的层序遍历 ---- 队列
     * @param root 树
     * @return 层序遍历的所有节点
     */
    List<T> levelOrderTraverse(TreeNode<T> root);

}
