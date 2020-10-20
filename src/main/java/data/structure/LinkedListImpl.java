/**
 *
 */
package data.structure;

/**
 * @author weiyan.xiang
 * @date 1 Feb 2018
 */
/*
 * a single linked list impl
 */
public class LinkedListImpl {

    public static Node root;

    /**
     * have the node def first
     *
     * @author weiyan.xiang
     * @date 1 Feb 2018
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void addFirst(Node element) {
        element.next = root;
        root = element;
    }

    public static void addLast(Node element) {
        if (root == null) root = element;
        Node node = root;
        while (node.next != null) {
            node = node.next;
        }
        node.next = element;
    }

    /**
     * can also keep track of size in add and delete
     */
    public int size() {
        if (root == null) return 0;
        int size = 0;
        Node node = root;
        while (node.next != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    public void clear() {
        root = null;
    }

    public static boolean removeValue(int data) {
        if (root == null) {
            return false;
        }
        if (root.value == data) {
            root = root.next;
            return true;
        }
        Node node = root;
        while (node.next != null) {
            if (node.next.value == data) {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void add(int index, Node element) {
        if (root == null && index != 0) return;
        if (index == 0) {
            addFirst(element);
            return;
        }
        Node node = root;
        int counter = 0;
        while (counter < index - 1 && node.next != null) {
            node = node.next;
            counter++;
        }
        element.next = node.next;
        node.next = element;
    }

    /**
     * return element previously in the position
     *
     * @param index
     * @return
     */
    public static Node remove(int index) {
        if (index == 0) {
            root = root.next;
            return root;
        }
        Node node = root;
        int counter = 0;
        while (counter < index - 1 && node.next != null) {
            node = node.next;
            counter++;
        }
        Node toReturn = node.next;
        node.next = node.next.next;
        return toReturn;

    }

    public static Node getFirst() {
        return root == null ? null : root;
    }

    public static Node getLast() {
        if (root == null) {
            return null;
        }
        Node node = root;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public static Node get(int index) {
        Node node = root;
        int counter = 0;
        while (counter < index && node.next != null) {
            node = node.next;
            counter++;
        }
        if (counter == index)
            return node;
        return null;
    }

    public static void main(String[] args) {

        root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        /**
         * root -> node1 -> node2 -> node3 -> node4 -> node5
         */
        Node newNode = new Node(100);
        addFirst(newNode);
        printLinkedList(newNode);

        Node lastNode = new Node(200);
        addLast(lastNode);
        printLinkedList(root);

        remove(6);
        remove(0);
        printLinkedList(root);

        remove(3);
        printLinkedList(root);

        System.out.println("current root value is: " + getFirst().value);
        System.out.println("current value at index 2 is: " + get(2).value);
        System.out.println("current value at index 5 is: " + get(10));

        Node testNode = new Node(3);
        add(3, testNode);
        printLinkedList(root);

    }

    public static void printLinkedList(Node newNode) {
        System.out.println();
        Node element = newNode;
        while (element != null) {
            System.out.print(element.value + " -> ");
            element = element.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}
