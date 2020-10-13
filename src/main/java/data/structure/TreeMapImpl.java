package data.structure;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Logger;

public class TreeMapImpl {

    private static final Logger LOGGER = Logger.getLogger(TreeMapImpl.class.getName());

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
        treeMap.put(new Key(3, "C"), " 3");
        treeMap.put(new Key(1, "A"), " 1");
        treeMap.put(new Key(2, "B"), " 2");
        treeMap.put(new Key(2, "A"), " 4");

        /*
         * Treemap class is like HashMap which stores key- value pairs . The
         * major difference is that Treemap sorts the key in ascending order.
         */
        for (Entry<Key, String> entry : treeMap.entrySet()) {
            System.out.println("key: " + entry.getKey().getValue() + ", value: " + entry.getValue());
        }

        TreeMap<Integer, Integer> anotherTreeMap = new TreeMap<>();
        anotherTreeMap.put(1, 1);
        anotherTreeMap.put(2, 2);
        anotherTreeMap.put(3, 3);
        anotherTreeMap.put(4, 4);
        anotherTreeMap.put(6, 6);
        anotherTreeMap.put(7, 7);
        System.out.println("ceiling entry of key 5 (least ket-value pair which is > the given key) should should be 6, actual: " +
                anotherTreeMap.ceilingEntry(5).getValue());

        System.out.println("ceilingKey of 5 should should be 6, actual: " +
                anotherTreeMap.ceilingKey(5));

        System.out.println("floor entry of key 5 (least ket-value pair which is > the given key) should should be 4, actual: " +
                anotherTreeMap.floorEntry(5).getValue());

    }

    public static void main(String[] args) {
        testTreeMap();
    }

}
