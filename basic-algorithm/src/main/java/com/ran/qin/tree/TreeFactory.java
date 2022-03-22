/**
 * @Classname Tree
 * @Description 树
 * @Date 2021/12/31 10:15 上午
 * @author zhangqin
 */

package com.ran.qin.tree;

import java.util.List;

public interface TreeFactory<T> {

    /**
     * 创建二叉树：递归方法
     * @param treeNodeList 需要创建二叉树的数据集合
     * @return 二叉树
     */
    TreeNode<T> createBinaryTree(List<T> treeNodeList);
}
