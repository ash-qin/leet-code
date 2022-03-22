/**
 * @Classname TreeFactoryImpl
 * @Description 树生成，便利工厂
 * @Date 2022/3/22 1:51 下午
 * @author zhangqin
 */

package com.ran.qin.tree.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import com.ran.qin.tree.TreeFactory;
import com.ran.qin.tree.TreeNode;

import java.util.List;

public class TreeFactoryImpl<T> implements TreeFactory<T> {


    /**
     * 创建二叉树：递归方法
     *
     * @param treeNodeList 需要创建二叉树的数据集合
     * @param index 需要开始创建节点的下标
     * @return 二叉树
     */
    public TreeNode<T> createBinaryTreeLayerSequence(int index, List<T> treeNodeList) {

        if (index > treeNodeList.size() - 1) {
            return null;
        }

        TreeNode<T> root = new TreeNode<T>();

        root.setVal(treeNodeList.get(index));
        root.setLeft(createBinaryTreeLayerSequence(index*2+1, treeNodeList));
        root.setRight(createBinaryTreeLayerSequence(index*2+2, treeNodeList));
        return root;
    }

    /**
     * 创建二叉树：递归方法 ---- 前序&中序
     *
     * @param preList 二叉树前序序列
     * @param inList  二叉树中序序列
     * @return 二叉树
     */
    public TreeNode<T> createBinaryTreePreInSequence(List<T> preList, List<T> inList) {

        if (CollUtil.isEmpty(preList) || CollUtil.isEmpty(inList)){
            return null;
        }

        if (preList.size() != inList.size()){
           return null;
        }
        int index ;
        for ( index = 0; index <inList.size(); index++) {
            if(inList.get(index) == preList.get(0)){
                break;
            }
        }
        TreeNode<T> root= new TreeNode<T>(preList.get(0));

        root.setLeft(createBinaryTreePreInSequence(
                ListUtil.sub(preList, 1, index+1)
                , ListUtil.sub(inList, 0, index)
        ));
        root.setRight(createBinaryTreePreInSequence(
                ListUtil.sub(preList, index+1, preList.size())
                , ListUtil.sub(inList, index+1, inList.size())
        ));
        return root;
    }

}
