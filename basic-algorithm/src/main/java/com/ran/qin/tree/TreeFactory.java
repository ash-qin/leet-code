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
     * 创建二叉树：递归方法 ---- 层序
     * @param index 需要开始创建节点的下标
     * @param treeNodeList 需要创建二叉树的数据集合
     * @return 二叉树
     */
    TreeNode<T> createBinaryTreeLayerSequence(int index, List<T> treeNodeList);

    /**
     * 创建二叉树：递归方法 ---- 前序&中序
     * @param preList 二叉树前序序列
     * @param inList 二叉树中序序列
     * @return 二叉树
     */
    TreeNode<T> createBinaryTreePreInSequence(List<T> preList, List<T> inList);
}
