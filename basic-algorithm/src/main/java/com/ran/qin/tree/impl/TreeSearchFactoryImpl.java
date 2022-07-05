/**
 * @Classname TreeSearchFactoryImpl
 * @Description 树的查询操作实现
 * @Date 2022/3/22 9:38 下午
 * @author zhangqin
 */

package com.ran.qin.tree.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import com.ran.qin.tree.model.TreeNode;
import com.ran.qin.tree.factories.TreeSearchFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSearchFactoryImpl<T> implements TreeSearchFactory<T> {
    /**
     * 树的先序便利 ---- 递归
     *
     * @param root 树
     * @return 先序遍历的所有节点
     */
    @Override
    public List<T> preOrderTraverse(TreeNode<T> root) {

        if (root == null) {
            return ListUtil.empty();
        }
        List<T> result = new ArrayList<T>();
        result.add(root.getVal());
        result.addAll(preOrderTraverse(root.getLeft()));
        result.addAll(preOrderTraverse(root.getRight()));
        return result;
    }

    /**
     * 树的中序遍历 ---- 递归
     *
     * @param root 树
     * @return 中序遍历的所有节点
     */
    @Override
    public List<T> inOrderTraverse(TreeNode<T> root) {
        if (root == null) {
            return ListUtil.empty();
        }
        List<T> result = new ArrayList<T>();
        result.addAll(inOrderTraverse(root.getLeft()));
        result.add(root.getVal());
        result.addAll(inOrderTraverse(root.getRight()));
        return result;
    }

    /**
     * 树的后序遍历 ---- 递归
     *
     * @param root 树
     * @return 后序遍历的所有节点
     */
    @Override
    public List<T> postOrderTraverse(TreeNode<T> root) {
        if (root == null) {
            return ListUtil.empty();
        }
        List<T> result = new ArrayList<T>();
        result.addAll(postOrderTraverse(root.getLeft()));
        result.addAll(postOrderTraverse(root.getRight()));
        result.add(root.getVal());
        return result;
    }

    /**
     * 树的层序遍历 ---- 队列
     *
     * @param root 树
     * @return 层序遍历的所有节点
     */
    @Override
    public List<T> levelOrderTraverse(TreeNode<T> root) {
        if (root == null) {
            return ListUtil.empty();
        }
        Queue<TreeNode<T>> search = new LinkedList<TreeNode<T>>();
        List<T> result = new ArrayList<T>();
        search.add(root);
        while (CollUtil.isNotEmpty(search)) {
            TreeNode<T> poll = search.poll();
            result.add(poll.getVal());
            if (poll.getLeft() != null) {
                search.add(poll.getLeft());
            }
            if (poll.getRight() != null) {
                search.add(poll.getRight());
            }
        }
        return result;
    }
}
