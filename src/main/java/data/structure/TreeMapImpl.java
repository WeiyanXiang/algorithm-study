package data.structure;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapImpl {

    private static class Key implements Comparable<Key> {
        private int value;
        private String type;

        /**
         * @param value
         * @param type
         */
        public Key(int value, String type) {
            this.value = value;
            this.type = type;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public int compareTo(Key o) {
            return this.value - o.value;
        }

    }

    public static void testTreeMap() {
        TreeMap<Key, String> treeMap = new TreeMap<>();
        treeMap.put(new Key(3, "C"), "value 3");
        treeMap.put(new Key(1, "A"), "value 1");
        treeMap.put(new Key(2, "B"), "value 2");
        treeMap.put(new Key(2, "A"), "value 4");

        /*
         * Treemap class is like HashMap which stores key- value pairs . The
         * major difference is that Treemap sorts the key in ascending order.
         */
        for (Entry<Key, String> entry : treeMap.entrySet()) {
            System.out.println("key: " + entry.getKey().getValue() + " ,value: " + entry.getValue());
        }

    }

    public static void main(String[] args) {
        testTreeMap();
    }

}
