/**
 * @Classname TreeNode
 * @Description 二叉树对象
 * @Date 2021/12/29 3:35 下午
 * @author zhangqin
 */

package com.ran.qin.tree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
    }
}