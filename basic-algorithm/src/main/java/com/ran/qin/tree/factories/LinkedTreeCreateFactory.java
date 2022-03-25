/**
 * @Classname LinkedTreeCreateFactory
 * @Description 连接树创建工厂
 * @Date 2022/3/24 10:44 上午
 * @author zhangqin
 */

package com.ran.qin.tree.factories;

import com.ran.qin.tree.model.LinkedTreeNode;

import java.util.List;

public interface LinkedTreeCreateFactory<T> {

    /**
     * 创建连接二叉树：递归方法 ---- 层序
     * @param index 需要开始创建节点的下标
     * @param treeNodeList 需要创建连接二叉树的数据集合
     * @return 连接二叉树
     */
    LinkedTreeNode<T> createBinaryTreeLayerSequence(int index, List<T> treeNodeList);

    /**
     * 创建连接二叉树：递归方法 ---- 前序&中序
     * @param preList 连接二叉树前序序列
     * @param inList 连接二叉树中序序列
     * @return 连接二叉树
     */
    LinkedTreeNode<T> createBinaryTreePreInSequence(List<T> preList, List<T> inList);

    /**
     * 创建连接二叉树：递归方法 ---- 后序&中序
     * @param postList 连接二叉树前序序列
     * @param inList 连接二叉树中序序列
     * @return 连接二叉树
     */
    LinkedTreeNode<T> createBinaryTreePostInSequence(List<T> postList, List<T> inList);

}
