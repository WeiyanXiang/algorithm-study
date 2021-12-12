package linkedlist;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;


public class ReorderList {

    /**
     * 143. Reorder List
     * <p>
     * Reorder List https://leetcode.com/problems/reorder-list/
     * <p>
     * upvoted ans
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // find mid
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // cut the list
        prev.next = null;

        // reverse second half
        ListNode n2 = reverse(slow);
        // merge
        ListNode n1 = head;
        merge(n1, n2);
    }

    void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;

        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    /**
     * my ac answer, iterative, using an additional list
     */
    public void reorderListWithList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        int len = nodes.size();
        int mid = len / 2;
        for (int i = 0; i < nodes.size(); i++) {
            // for each node on first half, point to the right;
            // for each node on second half, point back to previous+1
            if (i < len / 2) nodes.get(i).next = nodes.get(len - 1 - i);
            else nodes.get(i).next = i == mid ? null : nodes.get(len - i);
        }
    }

}
