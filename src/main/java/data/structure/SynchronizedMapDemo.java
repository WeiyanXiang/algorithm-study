package data.structure;

import java.util.*;

/**
 * @author Weiyan Xiang on 2020/3/23
 */
public class SynchronizedMapDemo {

    public static void main(String[] args) {

        Map<String, String> currencies = new HashMap<>();
        currencies.put("USA", "USD");
        currencies.put("England", "GBP");
        currencies.put("Canada", "CAD");
        currencies.put("HongKong", "HKD");
        currencies.put("Australia", "AUD");

        /**
         * Collections.synchronizedMap() is a useful method to achieve this but you also have better options available
         * in Java. For example, if you know from the start that your HashMap will be shared between multiple threads
         * then why not use ConcurrentHashMap, which is specially designed for such use. Unfortunately, if you have not
         * yet on Java 1.5 then there is Hashtable which provides similar functionality like synchronized HashMap.
         *
         */
        currencies = Collections.synchronizedMap(currencies);

        Set<String> keySet = currencies.keySet();
        synchronized (currencies) {
            // Must be in synchronized block while (itr.hasNext()){ System.out.println(itr.next()); } }
            Iterator<String> itr = keySet.iterator();

        }
    }
}