/**
 *
 */
package data.structure.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weiyan.xiang
 * @date 9 Feb 2018
 */
public class LRUCacheImpl {

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int count;
    private int size;

    public class Node {
        public Integer key;
        public Integer value;
        public Node prev;
        public Node next;

        /**
         * double linked list
         *
         * @param key
         * @param value
         */
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public void addFirst(Node newRoot) {
            if (head.key == null || head == null) {
                head = newRoot;
            } else {
                if (head.next == null) {
                    tail = head;
                }
                newRoot.next = head;
                head.prev = newRoot;
                head = newRoot;
            }
        }

        public Node popTail() {
            Node toReturn = tail;
            if (tail != null) {
                tail.prev.next = null;
                tail = tail.prev;
            }
            return toReturn;
        }

    }

    /**
     * @param map
     * @param head
     */
    public LRUCacheImpl(int size) {
        this.map = new HashMap<>();
        this.head = new Node(null, null);
        this.tail = null;
        this.size = size;
        this.count = 0;
    }

    public Integer put(int key, int value) {
        if (count < size) {
            /*
             * since not reach size, map just put, cache just enqueue to first each
             * time
             */
            Node toAdd = new Node(key, value);
            head.addFirst(toAdd);
            map.put(key, new Node(key, value));
            count++;
            return null;
        } else {
            if (map.containsKey(key)) {
                /*
                 * reaching size and key already in cache, move the key to head
                 * in cache
                 */
                Node toMove = map.get(key);
                int oldValueToReturn = toMove.value;
                toMove.value = value;
                moveToHead(toMove);
                map.put(key, head);
                return oldValueToReturn;
            } else {
                /*
                 * reaching size and key not in cache, enqueue it to head and remove
                 * the last element in cache
                 */
                map.remove(tail.key);
                head.popTail();
                head.addFirst(new Node(key, value));
                map.put(key, head);
                return value;
            }
        }

    }

    private void moveToHead(Node node) {
        if (head != node) {
            Node prev = node.prev;
            Node next = node.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            head.addFirst(node);
        }
    }

    public Integer get(int key) {
        if (this.map.containsKey(key)) {
            moveToHead(map.get(key));
            return this.map.get(key).value;
        }
        return null;
    }

    public static void main(String[] args) {
        LRUCacheImpl testObj = new LRUCacheImpl(3);
        testObj.put(1, 1);
        testObj.put(2, 2);
        testObj.put(3, 3); // [3,2,1]
        printCache(testObj.head);
        testObj.put(4, 4); // [4,3,2]
        printCache(testObj.head);
        testObj.put(1, 1); // [1,4,3]
        printCache(testObj.head);
        testObj.put(2, 2); // [2,1,4]
        printCache(testObj.head);
        testObj.put(5, 5); // [5,2,1]
        printCache(testObj.head);
        testObj.put(1, 1); // [1,5,2]
        printCache(testObj.head);
        testObj.put(2, 2); // [2,1,5]
        printCache(testObj.head);
        testObj.put(3, 3); // [3,2,1]
        printCache(testObj.head);
        testObj.put(4, 4); // [4,3,2]
        printCache(testObj.head);
        testObj.put(5, 5); // [5,4,3]
        printCache(testObj.head);
        testObj.get(4); // [4,5,3]
        printCache(testObj.head);
        testObj.put(2, 2); // [2,4,5]
        printCache(testObj.head);
        testObj.get(5); // [5,2,4]
        printCache(testObj.head);

    }

    private static void printCache(Node head) {
        Node toLoop = head;
        System.out.println();
        while (toLoop.next != null) {
            System.out.print(toLoop.value + " -> ");
            toLoop = toLoop.next;
        }
        System.out.print(toLoop.value);

    }

}
