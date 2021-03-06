package linkedlist;

/**
 * @author Weiyan Xiang on 2020/11/2
 */
public class AddTwoNumbers {

    /**
     * https://leetcode.com/problems/add-two-numbers/submissions/
     * <p>
     * below my answer:
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String test = "dsa";
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode c1 = l1;
        ListNode c2 = l2;
        boolean addOne = false;
        ListNode dummy = new ListNode(0);
        ListNode answer = dummy;
        while (c1 != null || c2 != null) {
            int d = 0;
            if (c1 != null) {
                d += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                d += c2.val;
                c2 = c2.next;
            }
            if (addOne) d++;
            if (d >= 10) {
                d %= 10;
                addOne = true;
            } else {
                addOne = false;
            }
            answer.next = new ListNode(d);
            answer = answer.next;
        }
        if (addOne) answer.next = new ListNode(1);
        return dummy.next;
    }

    /**
     * below optimal from LC, the boolean can be ignored
     */
    public ListNode addTwoNumbersOptimal(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

    /**
     * recursion version, upvoted answer
     */
    public ListNode addTwoNumbersRecursion(ListNode l1, ListNode l2) {
        return addUp(l1, l2, false);
    }

    private ListNode addUp(ListNode l1, ListNode l2, boolean addOne) {
        if (l1 == null && l2 == null && !addOne) return null;
        int cs = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (addOne ? 1 : 0);
        ListNode p = new ListNode(cs % 10);
        p.next = addUp(l1 == null ? null : l1.next, l2 == null ? null : l2.next, cs >= 10);
        return p;
    }

}
