package linkedlist;

import data.structure.linkedlist.LinkedListImpl;

/**
 * @author Weiyan Xiang on 2020/5/30
 */
public class HasCycle {
    public boolean hasCycle(LinkedListImpl.Node head) {
        if (head == null) return false;
        LinkedListImpl.Node fast = head.next;
        LinkedListImpl.Node slow = head;
        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListImpl.Node root = new LinkedListImpl.Node(3);
        LinkedListImpl.Node node1 = new LinkedListImpl.Node(2);
        LinkedListImpl.Node node2 = new LinkedListImpl.Node(0);
        LinkedListImpl.Node node3 = new LinkedListImpl.Node(-4);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        HasCycle testObj = new HasCycle();
        System.out.println("true == " + testObj.hasCycle(root));
    }
}
