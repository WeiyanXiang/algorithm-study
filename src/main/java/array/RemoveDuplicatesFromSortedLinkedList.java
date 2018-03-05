/**
 * 
 */
package array;

/**
 * @author weiyan.xiang
 * @date 5 Mar 2018
 */
public class RemoveDuplicatesFromSortedLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Given a sorted linked list, delete all duplicates such that each element
     * appear only once.
     * 
     * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
     * 1->2->3.
     * 
     * @param head
     * @return
     */
    public static ListNode deleteDuplicatesMyAnswer(ListNode head) {
        if (head == null)
            return null;
        ListNode node = head;
        while (node != null) {
            ListNode toLoop = node.next;
            while (toLoop != null && node.val == toLoop.val) {
                toLoop = toLoop.next;
            }
            node.next = toLoop;
            node = node.next;
        }
        return head;
    }

    public static ListNode deleteDuplicatesBetter(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                break;
            }
            if (node.val == next.val) {
                node.next = next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(1);
        ListNode h3 = new ListNode(1);
        ListNode h4 = new ListNode(3);
        ListNode h5 = new ListNode(3);

        h4.next = h5;
        h3.next = h4;
        h2.next = h3;
        h1.next = h2;

        printLinkedList(deleteDuplicatesMyAnswer(h1));
        System.out.println();
        printLinkedList(deleteDuplicatesBetter(h1));

    }

    private static void printLinkedList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }
}
