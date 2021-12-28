/**
 * @Classname MiddleNode
 * @Description leetCode - 876 . 链表的中间节点
 * @Date 2021/12/17 9:31 上午
 * @author zhangqin
 */

package com.ran.qin.double_pointer.linkedlist;

public class MiddleNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode point = head;
        for (int i = 2; i <= 6; i++) {
            point = point.add(i);
        }
        MiddleNode m = new MiddleNode();
        ListNode listNode = m.middleNode(head);
        System.out.println(listNode.getVal());

        head.print();

    }

    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode pointer = head;
        while (pointer != null) {
            ++length;
            pointer = pointer.next;
        }
        int index = 0;
        pointer = head;
        while (index < length / 2) {
            ++index;
            pointer = pointer.next;
        }
        return pointer;
    }
}
