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
     * <p>
     * tricky part is to invalidate head's child since done with flatten
     */
    public Node flatten(Node head) {
        // bottom up dfs
        if (head == null) return null;
        if (head.child == null) head.next = flatten(head.next);
        if (head.child != null) {
            Node flatChild = flatten(head.child);
            // connect tail of flatten
            Node curFlatChild = flatChild;
            while (curFlatChild.next != null) curFlatChild = curFlatChild.next;
            Node nextNode = head.next;
            curFlatChild.next = nextNode;
            if (nextNode != null) nextNode.prev = curFlatChild;
            // connect head of flatten
            head.next = flatChild;
            flatChild.prev = head;
            // invalidate head's child since done with flatten
            head.child = null;
        }
        return head;
    }

    /**
     * recur only for flatten children
     */
    public Node flattenMyAnotherAns(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node nextNode = cur.next;
                Node child = flatten(cur.child);
                // connect head of flatten
                child.prev = cur;
                cur.next = child;
                Node curChild = child;
                while (curChild.next != null) {
                    curChild = curChild.next;
                }
                // connect tail of flatten
                curChild.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = curChild;
                }
                // invalidate cur's child
                cur.child = null;
                cur = nextNode;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
