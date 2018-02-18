/**
 * 
 */
package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weiyan.xiang
 * @date 18 Feb 2018
 */
public class RemoveDuplicatesFromLinkedList {

    private static Node head;

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        RemoveDuplicatesFromLinkedList list = new RemoveDuplicatesFromLinkedList();
        list.head = list.new Node(10);
        list.head.next = list.new Node(12);
        list.head.next.next = list.new Node(11);
        list.head.next.next.next = list.new Node(10);
        list.head.next.next.next.next = list.new Node(12);
        list.head.next.next.next.next.next = list.new Node(11);
        list.head.next.next.next.next.next.next = list.new Node(10);

        System.out.println("Linked List Before removing duplicates: ");
        list.printList(head);

        list.remove_duplicates();
        System.out.println("\nLinked List After removing duplicates:  ");
        list.printList(head);
    }

    private void remove_duplicates() {
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        Node node = head;
        while (node != null) {
            set.add(node.val);
            Node nextValidNode = node.next;
            while (nextValidNode != null && set.contains(nextValidNode.val)) {
                node.next = nextValidNode.next;
                nextValidNode = nextValidNode.next;
            }
            node = node.next;
        }
    }

    private void printList(Node node) {
        while (node != null) {
            if (node.next != null)
                System.out.print(node.val + " -> ");
            else
                System.out.print(node.val);
            node = node.next;
        }
    }

}
