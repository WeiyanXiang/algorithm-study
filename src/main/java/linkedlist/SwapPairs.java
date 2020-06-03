package linkedlist;

/**
 * @author Weiyan Xiang on 2020/6/2
 */
public class SwapPairs {
    /**
     * breaking + task + return are 3 parts for a recursion design
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // breaking
        if (head == null || head.next == null) {
            return head;
        }
        // task
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        // return
        return next;
    }
}
