/**
 * @Classname TreeNode
 * @Description 二叉树对象
 * @Date 2021/12/29 3:35 下午
 * @author zhangqin
 */

package com.ran.qin.tree;

public class TreeNode<T> {
    T val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(T val) {
        this.val = val;
    }

    TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}