/**
 * 
 */
package data.structure.lru;

import java.util.LinkedHashMap;

/**
 * @author weiyan.xiang
 * @date 10 Feb 2018
 */
public class LRUUsingLinkedHashMapImpl extends LinkedHashMap<Integer, Integer> {

    /**
     * 
     */
    private static final long serialVersionUID = -7283040717654602877L;
    private int capacity;

    /**
     * @param capacity
     */
    public LRUUsingLinkedHashMapImpl(int capacity, float loadFactor) {
        /*
         * third params is accessOrder - the ordering mode - TRUE for
         * access-order, FALSE for insertion-order
         */
        super(capacity, loadFactor, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.forEach((k, v) -> {
            builder.append(k + " <- ");
        });
        return builder.toString();
    }

    public static void main(String[] args) {
        LRUUsingLinkedHashMapImpl instance = new LRUUsingLinkedHashMapImpl(3, 0.75f);
        instance.put(1, 1);
        instance.put(2, 2);
        instance.put(3, 3); // [3,2,1]
        System.out.println(instance);
        instance.put(4, 4); // [4,3,2]
        System.out.println(instance);
        instance.get(2); // [2,4,3]
        System.out.println(instance);
        instance.get(4); // [4,2,3]
        System.out.println(instance);
        instance.put(2, 2); // [2,4,3]
        System.out.println(instance);
        instance.put(3, 3); // [3,2,4]
        System.out.println(instance);

    }
}
