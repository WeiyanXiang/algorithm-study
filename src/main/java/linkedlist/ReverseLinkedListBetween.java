package linkedlist;

/**
 * @author Weiyan Xiang on 2020/11/1
 */
public class ReverseLinkedListBetween {
    //@formatter:off
    /**
     * Note: 1 ≤ m ≤ n ≤ length of list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL
     */
    //@formatter:on
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        int i = 1;

        ListNode cur = head;
        ListNode prev = null;
        ListNode dummy = new ListNode(1);
        dummy.next = cur;

        while (cur != null && i < m) {
            prev = cur;
            cur = cur.next;
            i++;
        }
        if (prev == null) {
            return doReverseAndFillTail(head, i, n);
        }
        prev.next = doReverseAndFillTail(cur, i, n);
        return dummy.next;
    }


    public ListNode doReverseAndFillTail(ListNode head, int i, int n) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null && i <= n) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            i++;
        }
        head.next = cur;
        return prev;
    }
}
