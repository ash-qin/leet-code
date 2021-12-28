/**
 * @Classname RemoveNthFromEnd
 * @Description leetCode - 19 . 删除链表的倒数第n个节点
 * @Date 2021/12/17 11:27 上午
 * @author zhangqin
 */

package com.ran.qin.double_pointer.linkedlist;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode point = head;
//        for (int i = 2; i <= 5; i++) {
//            point = point.add(i);
//        }
        RemoveNthFromEnd m = new RemoveNthFromEnd();
        ListNode listNode = m.removeNthFromEnd(head, 1);
        if (listNode == null){
            System.out.println("[]");
        }else {
            System.out.println(listNode.getVal());
        }

        head.print();

    }

    /**
     * 如果从当前第一个节点开始遍历删除的是第一个节点就不好操作，就人为的在第一个节点前加一个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = 0;
        ListNode pointer = dummy;
        while (pointer != null) {
            ++length;
            pointer = pointer.next;
        }
        int index = 0;
        pointer = dummy;
        while(pointer.next != null && index< length - n -1){
            pointer = pointer.next;
            index++;
        }
        pointer.next = pointer.next.next;
        return dummy.next;
    }
}
