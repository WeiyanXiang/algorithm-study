package data.structure;
/**
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author weiyan.xiang
 * @date 23 Jan 2018
 */
public class HashMapImpl {
    private List<LinkedList<MyEntry>> buckets;
    private int capacity = 16;

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
        LinkedList<MyEntry> bucket = this.buckets.get(hashCode(key) & (capacity - 1));
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
        LinkedList<MyEntry> bucket = this.buckets.get(hashCode(key) & (capacity - 1));
        for (MyEntry entry : bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    public class MyEntry {
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
