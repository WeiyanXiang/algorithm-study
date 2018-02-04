/**
 * 
 */
package sort;

/**
 * @author weiyan.xiang
 * @date 4 Feb 2018
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a = l1, b = l2;
        ListNode answer = null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (a.val < b.val) {
            answer = new ListNode(a.val);
            a = a.next;
        } else {
            answer = new ListNode(b.val);
            b = b.next;
        }
        ListNode loopNode = answer;
        while (a != null || b != null) {
            if (b == null) {
                loopNode.next = new ListNode(a.val);
                a = a.next;
            } else if (a == null) {
                loopNode.next = new ListNode(b.val);
                b = b.next;
            } else if (a.val < b.val) {
                loopNode.next = new ListNode(a.val);
                a = a.next;
            } else if (a.val >= b.val) {
                loopNode.next = new ListNode(b.val);
                b = b.next;
            }
            loopNode = loopNode.next;
        }
        return answer;
    }

    /**
     * recursive version optimal
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        MergeTwoSortedLists testObject = new MergeTwoSortedLists();
        /*
         * 1 -> 2 -> 4
         */
        ListNode l1 = testObject.new ListNode(1);
        ListNode l2 = testObject.new ListNode(2);
        ListNode l3 = testObject.new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        /*
         * 1 -> 3 -> 4 -> 6
         */
        ListNode r1 = testObject.new ListNode(1);
        ListNode r2 = testObject.new ListNode(3);
        ListNode r3 = testObject.new ListNode(4);
        ListNode r4 = testObject.new ListNode(6);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;

        ListNode answer = testObject.mergeTwoLists(l1, r1);
        ListNode anotherAnswer = testObject.mergeTwoListsRecursive(l1, r1);
        print(answer);
        System.out.println();
        print(anotherAnswer);
    }

    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
            if (listNode != null)
                System.out.print(" -> ");
        }
    }
}
