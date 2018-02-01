/**
 * 
 */
package data.structure;

import java.util.LinkedList;

/**
 * @author weiyan.xiang
 * @date 1 Feb 2018
 */
/*
 * a single linked list impl
 */
public class LinkedListImpl {

    /**
     * have the node def first
     * 
     * @author weiyan.xiang
     * @date 1 Feb 2018
     */
    private static class Node {
        private int value;
        private Node prev;
        private Node next;

        /**
         * @param value
         * @param prev
         * @param next
         */
        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    // addFirst(Node element)
    //
    // addLast(Node element)
    //
    // add(int index, Node element)
    //
    // remove(int index)
    //
    // remove(Node element)
    //
    // Node getFirst()
    //
    // Node get(int index)

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
    }
}
