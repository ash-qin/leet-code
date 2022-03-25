/**
 * @Classname TreeNode
 * @Description 二叉树对象
 * @Date 2021/12/29 3:35 下午
 * @author zhangqin
 */

package com.ran.qin.tree.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class TreeNode<T> {

    /**
     * 树节点的数据
     */
    T val;

    /**
     * 左子树
     */
    TreeNode<T> left;

    /**
     * 又子树
     */
    TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
    }
}