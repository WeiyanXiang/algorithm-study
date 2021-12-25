package data.structure.lru;/**
 * @author Weiyan Xiang on 2021/12/25
 */

import java.util.*;

public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    /**
     * 146. LRU Cache
     * <p>
     * https://leetcode.com/problems/lru-cache/
     * <p>
     * my ans learnt from upvote: double linked list + map,
     * <p>
     * 1. tricky part is to remove node first and add to head second, otherwise if add first remove second, it will mess
     * up the reference as 2 nodes added
     * <p>
     * 2. head and tail use dummy node to avoid checking null each time
     */
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-2, -2);
        head.next = tail;
        tail.prev = head;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(Node node) {
        Node preNode = node.prev;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.prev = preNode;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node found = map.get(key);
            found.val = value;
            remove(found);
            addToHead(found);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (size < capacity) {
                size++;
            } else {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            addToHead(node);
        }
    }
}
