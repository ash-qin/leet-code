/**
 * @Classname ListNode
 * @Description 链表节点
 * @Date 2021/12/17 9:34 上午
 * @author zhangqin
 */

package com.ran.qin.double_pointer.linkedlist;

import lombok.Data;

@Data
public class ListNode {


    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 添加下一个节点，并返回下一个节点
     * @param nextInt
     * @return
     */
    ListNode add(int nextInt) {
        ListNode next = new ListNode();
        next.setVal(nextInt);
        this.setNext(next);
        return next;
    }

    // 打印链表
    public void print() {
        System.out.print(this.val);
        if(this.next != null)
        {
            System.out.print("-->");
            this.next.print();
        }
    }

}
