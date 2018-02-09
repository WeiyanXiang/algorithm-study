/**
 * 
 */
package data.structure;

import java.util.HashMap;
import java.util.Map;

import data.structure.LinkedListImpl.Node;

/**
 * @author weiyan.xiang
 * @date 9 Feb 2018
 */
public class LRUCacheImpl {

    private Map<Integer, Integer> map;
    private LinkedListImpl cache;
    private int count;
    private int size;

    /**
     * @param map
     * @param cache
     */
    public LRUCacheImpl(int size) {
        this.map = new HashMap<>();
        this.cache = new LinkedListImpl();
        this.size = size;
        this.count = 0;
    }

    @SuppressWarnings("static-access")
    public Integer put(int key, int value) {
        if (count < size) {
            map.put(key, value);
            cache.addFirst(new Node(value));
            count++;
            return null;
        } else {
            if (map.containsKey(key)) {
                int toReturn = map.get(key);
                map.put(key, value);
                moveToHead(new Node(key));
                return toReturn;
            } else {
                map.remove(cache.get(size - 1).getValue());
                cache.remove(size - 1);
                cache.addFirst(new Node(value));
                return map.put(key, value);
            }
        }

    }

    @SuppressWarnings("static-access")
    private void moveToHead(Node node) {
        cache.addFirst(node);
        Node toLoop = cache.root;
        while (toLoop.getNext() != null) {
            if (toLoop.getNext().getValue() == node.getValue()) {
                toLoop.setNext(toLoop.getNext().getNext());
                break;
            }
            toLoop = toLoop.getNext();
        }
    }

    public Integer get(int key) {
        return this.map.get(key);
    }

    public static void main(String[] args) {
        LRUCacheImpl testObj = new LRUCacheImpl(3);
        testObj.put(1, 1);
        testObj.put(2, 2);
        testObj.put(3, 3); // [3,2,1]
        printCache(testObj);
        testObj.put(4, 4); // [4,3,2]
        printCache(testObj);
        testObj.put(1, 1); // [1,4,3]
        printCache(testObj);
        testObj.put(2, 2); // [2,1,4]
        printCache(testObj);
        testObj.put(5, 5); // [5,2,1]
        printCache(testObj);
        testObj.put(1, 1); // [1,5,2]
        printCache(testObj);
        testObj.put(2, 2); // [2,1,5]
        printCache(testObj);
        testObj.put(3, 3); // [3,2,1]
        printCache(testObj);
        testObj.put(4, 4); // [4,3,2]
        printCache(testObj);
        testObj.put(5, 5); // [5,4,3]
        printCache(testObj);
    }

    private static void printCache(LRUCacheImpl input) {
        System.out.println();
        Node toLoop = input.cache.root;
        while (toLoop.getNext() != null) {
            System.out.print(toLoop.getValue() + " -> ");
            toLoop = toLoop.getNext();
        }
        System.out.print(toLoop.getValue());
    }

}
