/**
 * @Classname Node
 * @Description 节点
 * @Date 2022/6/18 20:56
 * @author zhangqin
 */

package com.ran.qin.common;

import lombok.Data;

@Data
public class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

    public void print(){
        Node node = this.next;
        System.out.print(val + " ");
        while(node != this){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
