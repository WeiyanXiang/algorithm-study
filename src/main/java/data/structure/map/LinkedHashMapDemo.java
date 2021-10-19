/**
 * 
 */
package data.structure.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author weiyan.xiang
 * @date 29 Jan 2018
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {

        /*
         * it differs from HashMap in that it maintains a doubly linked list
         * running through all of its entries. o The reason why double linked
         * list rather than single is because to implement O(1) removal of
         * element requires the node to know previous node as well.
         *
         */
        Map<String, String> testObj = new LinkedHashMap<>();

        testObj.put("key1", "value1");
        testObj.put("key2", "value2");
        testObj.put("key3", "value3");
        testObj.put("key2", "value4");
        testObj.put("key2", "value5");
        testObj.put("key3", "value6");

        /*
         * expect to see key1, key2 and key3 because even though key3 was
         * overwritten by its value at last step, the key3 already exists prior
         * to that, so the order will not be changed due to insertion
         */
        testObj.forEach((key, value) -> System.out.println(key + " - " + value));
    }

}
