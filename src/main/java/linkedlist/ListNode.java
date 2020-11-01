package linkedlist;

/**
 * @author Weiyan Xiang on 2020/5/31
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }


    public static void printLinkedList(ListNode newNode) {
        System.out.println();
        ListNode element = newNode;
        while (element != null) {
            System.out.print(element.val + " -> ");
            element = element.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static ListNode buildLinkedListFromArray(int[] input) {
        ListNode head = new ListNode(input[0]);
        ListNode cur = head;
        for (int i = 1; i < input.length; i++) {
            cur.next = new ListNode(input[i]);
            cur = cur.next;
        }
        return head;
    }
}