package linkedlist;

/**
 * @author Weiyan Xiang on 2020/5/30
 */
public class ReverseLinkedList {
    /**
     * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
     * <p>
     * https://leetcode.com/problems/reverse-linked-list/
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     * track 1 more node after, return cur
     */
    public ListNode reverseListThreeRef(ListNode head) {
        if (head == null) return null;
        ListNode prev = null, cur = head, after = cur.next;
        while (after != null) {
            ListNode nextNode = after.next;
            cur.next = prev;
            after.next = cur;
            prev = cur;
            cur = after;
            after = nextNode;
        }
        return cur;
    }

}
