package data.structure;

import java.util.TreeMap;

public class TreeMapImpl {

    private static class Key {
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

    }

    public static void testTreeMap() {
        TreeMap<Key, String> treeMap = new TreeMap<>();
        treeMap.put(new Key(1, "A"), "value 1");

    }

    public static void main(String[] args) {
    }

}
