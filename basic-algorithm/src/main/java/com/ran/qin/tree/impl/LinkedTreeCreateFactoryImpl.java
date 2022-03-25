/**
 * @Classname LinkedTreeCreateFactoryImpl
 * @Description 连接树创建工厂实现
 * @Date 2022/3/24 10:46 上午
 * @author zhangqin
 */

package com.ran.qin.tree.impl;

import com.ran.qin.tree.factories.LinkedTreeCreateFactory;
import com.ran.qin.tree.model.LinkedTreeNode;
import com.ran.qin.tree.model.TreeNode;

import java.util.List;

public class LinkedTreeCreateFactoryImpl<T> implements LinkedTreeCreateFactory<T> {
    /**
     * 创建连接二叉树：递归方法 ---- 层序
     *
     * @param index        需要开始创建节点的下标
     * @param treeNodeList 需要创建连接二叉树的数据集合
     * @return 连接二叉树
     */
    public LinkedTreeNode<T> createBinaryTreeLayerSequence(int index, List<T> treeNodeList) {

        if (index > treeNodeList.size() - 1) {
            return null;
        }

        LinkedTreeNode<T> root = new LinkedTreeNode<T>();

        root.setVal(treeNodeList.get(index));
        root.setLeft(createBinaryTreeLayerSequence(index*2+1, treeNodeList));
        root.setRight(createBinaryTreeLayerSequence(index*2+2, treeNodeList));
        return root;
    }

    /**
     * 创建连接二叉树：递归方法 ---- 前序&中序
     *
     * @param preList 连接二叉树前序序列
     * @param inList  连接二叉树中序序列
     * @return 连接二叉树
     */
    public LinkedTreeNode<T> createBinaryTreePreInSequence(List<T> preList, List<T> inList) {
        return null;
    }

    /**
     * 创建连接二叉树：递归方法 ---- 后序&中序
     *
     * @param postList 连接二叉树前序序列
     * @param inList   连接二叉树中序序列
     * @return 连接二叉树
     */
    public LinkedTreeNode<T> createBinaryTreePostInSequence(List<T> postList, List<T> inList) {
        return null;
    }
}
