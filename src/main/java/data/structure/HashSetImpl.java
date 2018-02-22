/**
 * 
 */
package data.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weiyan.xiang
 * @date 23 Jan 2018
 */
public class HashSetImpl {
    private Map<String, String> memory;
    /**
     * dummy value to save memory for the internal hashmap
     */
    private final static String DEFAULT_VALUE = "";

    public HashSetImpl() {
        this.memory = new HashMap<>();
    }

    public boolean add(String s) {
        return this.memory.put(s, DEFAULT_VALUE) == null;
    }

    public boolean remove(String s) {
        return this.memory.remove(s) != null;
    }

    public boolean contains(String s) {
        return this.memory.containsKey(s);
    }

}
