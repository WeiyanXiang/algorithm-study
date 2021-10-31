package linkedlist;

/**
 * @author Weiyan Xiang on 2021/10/31
 */

public class FlattenMultilevelDoublyLinkedList {

    /**
     * 430. Flatten a Multilevel Doubly Linked List
     * <p>
     * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
     * <p>
     * my ac ans
     */
    public Node flatten(Node head) {
        // bottom up dfs
        Node root = head;
        return convert(root);
    }

    private Node convert(Node head) {
        if (head == null) return null;
        if (head.child == null) head.next = convert(head.next);
        if (head.child != null) {
            Node toFlat = convert(head.child);
            // connect tail of flatten
            Node iToFlat = toFlat;
            while (iToFlat.next != null) iToFlat = iToFlat.next;
            Node curNext = head.next;
            iToFlat.next = curNext;
            if (curNext != null) curNext.prev = iToFlat;
            // connect head of flatten
            head.next = toFlat;
            toFlat.prev = head;
            // invalidate head's child since done with flatten
            head.child = null;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;

}
