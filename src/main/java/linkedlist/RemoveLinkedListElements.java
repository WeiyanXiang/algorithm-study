package linkedlist;

/**
 * @author Weiyan Xiang on 2020/5/31
 */
public class RemoveLinkedListElements {

    /**
     * my original correct impl
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null) {
            ListNode nextNote = current.next;
            while (current.next != null && current.next.val == val) {
                // perform repoint
                current.next = current.next.next;
            }
            current = nextNote;
        }
        return dummy.next;
    }

    /**
     * optimised iteration approach, same idea to mine but easier during indexing
     */
    public ListNode removeElementsRevised(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        /*
         * 1 -> 3 -> 4 -> 1 -> 6
         */
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(4);
        ListNode r4 = new ListNode(1);
        ListNode r5 = new ListNode(6);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;


        RemoveLinkedListElements testObj = new RemoveLinkedListElements();
        ListNode.printLinkedList(r1);
//        ListNode.printLinkedList(testObj.removeElements(r1, 1));
        System.out.println("Remove 1: ");
        ListNode.printLinkedList(testObj.removeElementsRevised(r1, 1));

    }
}
