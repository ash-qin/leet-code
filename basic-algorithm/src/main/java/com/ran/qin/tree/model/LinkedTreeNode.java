/**
 * @Classname LinkedTreeNode
 * @Description 带有兄弟节点指向的树的节点
 * @Date 2022/3/23 5:10 下午
 * @author zhangqin
 */

package com.ran.qin.tree.model;

import lombok.Data;

@Data
public class LinkedTreeNode<T> {

    /**
     * 树节点的数据
     */
    private T val;

    /**
     * 左子树
     */
    private LinkedTreeNode<T> left;

    /**
     * 右子树
     */
    private LinkedTreeNode<T> right;

    /**
     * 兄弟节点  左->右 右 -> null
     */
    private LinkedTreeNode<T> next;

}
