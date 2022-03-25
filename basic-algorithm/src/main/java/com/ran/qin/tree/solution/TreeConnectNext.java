/**
 * @Classname TreeConnectNext
 * @Description leetCode - 116. 填充每个节点的下一个右侧节点指针
 * @Date 2022/3/24 3:51 下午
 * @author zhangqin
 */

package com.ran.qin.tree.solution;

import cn.hutool.core.collection.CollUtil;
import com.ran.qin.tree.factories.LinkedTreeCreateFactory;
import com.ran.qin.tree.impl.LinkedTreeCreateFactoryImpl;
import com.ran.qin.tree.model.LinkedTreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeConnectNext {

    public static void main(String[] args) {
        TreeConnectNext connect = new TreeConnectNext();
        LinkedTreeCreateFactory<Integer> createFactory = new LinkedTreeCreateFactoryImpl<Integer>();
        LinkedTreeNode<Integer> tree = createFactory.createBinaryTreeLayerSequence(0, Arrays.asList(1, 2, 3, 4, 5, 6, 7));
//        connect.connect(tree);
        connect.connect_2(tree);
        System.out.println(tree);
    }

    /**
     * 解法一：使用队列 + 层序遍历的队列
     * @param root 树
     * @return 带有链接节点的树
     */
    public LinkedTreeNode<Integer> connect(LinkedTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        Queue<LinkedTreeNode<Integer>> search = new LinkedList<LinkedTreeNode<Integer>>();

        search.add(root);
        while (CollUtil.isNotEmpty(search)) {
            int size = search.size();
            for (int i = 0; i < size; i++) {
                LinkedTreeNode<Integer> poll = search.poll();
                if (i < size - 1) {
                    poll.setNext(search.peek());
                }
                if (poll.getLeft() != null) {
                    search.add(poll.getLeft());
                }
                if (poll.getRight() != null) {
                    search.add(poll.getRight());
                }
            }
        }
        return root;
    }

    /**
     * 解法二：借助上层确定的next处理下一层
     *  连接方式两种
     *  node.left.next = node.right
     *  node.right.next = node.next.left
     * @param root
     * @return
     */
    public LinkedTreeNode<Integer> connect_2(LinkedTreeNode<Integer> root){

        if (root == null){
            return null;
        }
        LinkedTreeNode<Integer> node = root;
        //循环到最后一层：node.getLeft == null 即循环出口
        while(node.getLeft() != null){
            //定义变量在本层流转
            LinkedTreeNode<Integer> head = node;
            while (head != null){

                    head.getLeft().setNext(head.getRight());

                if (head.getNext() != null){
                    head.getRight().setNext(head.getNext().getLeft());
                }
                head = head.getNext();
            }
            //流转到下一层：每层的第一个节点的left即下一层的第一个节点
            node = node.getLeft();
        }
        return root;
    }
}
