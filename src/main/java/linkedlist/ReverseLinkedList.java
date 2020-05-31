package linkedlist;

import static linkedlist.ListNode.printLinkedList;

/**
 * @author Weiyan Xiang on 2020/5/30
 */
public class ReverseLinkedList {
    /**
     * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
     * <p>
     * https://leetcode.com/problems/reverse-linked-list/
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode nextListNode = current.next;
            current.next = previous;
            previous = current;
            current = nextListNode;
        }
        return previous;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode ListNode1 = new ListNode(2);
        ListNode ListNode2 = new ListNode(3);
        ListNode ListNode3 = new ListNode(4);
        ListNode ListNode4 = new ListNode(5);
        root.next = ListNode1;
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode4;

        printLinkedList(root);

        ReverseLinkedList testObj = new ReverseLinkedList();
        printLinkedList(testObj.reverseList(root));
    }
}
