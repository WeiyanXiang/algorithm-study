/**
 *
 */
package linkedlist;

/**
 * @author weiyan.xiang
 * @date 4 Feb 2018
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoListsRevised(ListNode l1, ListNode l2) {
        ListNode a = l1, b = l2;
        ListNode dummyRoot = new ListNode(1);
        ListNode current = dummyRoot;
        while (a != null && b != null) {
            if (a.val < b.val) {
                // assign new ListNode if want to keep original l1 and l2 looking, otherwise just assign directly:
                // i.e. current.next = a;
                current.next = new ListNode(a.val);
                a = a.next;
            } else {
                current.next = new ListNode(b.val);
                b = b.next;
            }
            current = current.next;
        }
        while (a != null) {
            current.next = new ListNode(a.val);
            a = a.next;
            current = current.next;
        }
        while (b != null) {
            current.next = new ListNode(b.val);
            b = b.next;
            current = current.next;
        }
        return dummyRoot.next;
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
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        MergeTwoSortedLists testObject = new MergeTwoSortedLists();
        /*
         * 1 -> 2 -> 4
         */
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        /*
         * 1 -> 3 -> 4 -> 6
         */
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(4);
        ListNode r4 = new ListNode(6);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;

        ListNode answer2 = testObject.mergeTwoListsRevised(l1, r1);
        ListNode answer3 = testObject.mergeTwoListsRecursive(l1, r1);
        print(answer2);
        print(answer3);
    }

    public static void print(ListNode newNode) {
        System.out.println();
        ListNode element = newNode;
        while (element != null) {
            System.out.print(element.val + " -> ");
            element = element.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}
