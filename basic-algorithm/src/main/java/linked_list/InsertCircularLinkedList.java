/**
 * @Classname InsertCircularLinkedList
 * @Description leetCode - 剑指 Offer II 029. 排序的循环链表
 * @Date 2022/6/18 20:59
 * @author zhangqin
 */

package linked_list;

import com.ran.qin.common.Node;

public class InsertCircularLinkedList {

    public static void main(String[] args) {
        int[] nodes = {3,3,3};
        Node root = new Node();
        root.setVal(nodes.length > 0 ? nodes[0] : 0);
        Node lastNode = root;
        for (int i = 1; i < nodes.length; i++) {
            Node newNode = new Node();
            newNode.setVal(nodes[i]);
            lastNode.setNext(newNode);
            lastNode = lastNode.next;
        }
        lastNode.next = root;

        InsertCircularLinkedList i = new InsertCircularLinkedList();
        int insertValue = 0;
        i.insert(root, insertValue);
        root.print();
    }

    public Node insert(Node head, int insertVal) {

        Node node = new Node(insertVal);
        if (head == null){
            node.next = node;
            return node;
        }
        if (head.next == head){
            head.next = node;
            node.next = head;
            return head;
        }
        Node root = head;
        Node next = head.next;
        while(next != head){
            if (root.val <= insertVal && next.val>=insertVal){
                break;
            }
            if (root.val>next.val){
                if (insertVal > root.val || insertVal < next.val){
                break;
                }
            }
            root = root.next;
            next = next.next;
        }
        root.next = node;
        node.next = next;
        return head;
    }
}
