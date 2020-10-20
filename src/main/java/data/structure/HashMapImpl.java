package data.structure;
/**
 *
 */

import java.util.*;
import java.util.Map.Entry;

/**
 * @author weiyan.xiang
 * @date 23 Jan 2018
 */
public class HashMapImpl {
    private List<LinkedList<MyEntry>> buckets;
    private int capacity = 16;

    /**
     * each bucket is a linkedlist, the process of get: compute index, go to corresponding bucket to fetch value, use
     * .equals() to distinguish values in each bucket
     * <p>
     * the process of put: compute index, go to corresponding bucket, check via hashCode() and equals() method that if
     * both the keys are same. If keys are same, replace the value with current value. Otherwise connect this node
     * object to the previous node object via linked list and both are stored
     */
    /**
     * for my info, example hashCode is using a prime to multiply the class field
     @Override
     public int hashCode() {
     int hash = 7;
     hash = 31 * hash + (int) id;
     hash = 31 * hash + (name == null ? 0 : name.hashCode());
     hash = 31 * hash + (email == null ? 0 : email.hashCode());
     return hash;
     }
     */
    public HashMapImpl() {
        this.buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.buckets.add(new LinkedList<>());
        }
    }

    public int hashCode(int key) {
        return key;
    }

    @Override
    public boolean equals(Object anotherValue) {
        return super.equals(anotherValue);
    }

    public Object put(int key, Object value) {
        LinkedList<MyEntry> bucket = this.buckets.get(hashCode(key) % (capacity - 1));
        for (int i = 0; i < bucket.size(); i++) {
            MyEntry entryInCurrentBucket = bucket.get(i);
            if (entryInCurrentBucket.key == key) {
                bucket.get(i).setValue(value);
                return value;
            }

        }
        MyEntry myEntry = new MyEntry(key, value);
        bucket.add(myEntry);
        return null;
    }

    public Object get(int key) {
        LinkedList<MyEntry> bucket = this.buckets.get(hashCode(key) % (capacity - 1));
        for (MyEntry entry : bucket) {
            // internally it calls .equals method
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    class MyEntry {
        private final int key;
        private Object value;

        /**
         * @param key
         * @param value
         */
        public MyEntry(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public int getKey() {
            return key;
        }
    }

    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("1", "1");
        testMap.put("3", "3");
        for (Entry<String, String> entry : testMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        HashMapImpl aMap = new HashMapImpl();
        aMap.put(1, "value1");
        aMap.put(2, "value2");
        aMap.put(3, "value3");
        aMap.put(1, "value4");
        aMap.put(1, "value5");
        aMap.put(17, "value17");

    }
}
