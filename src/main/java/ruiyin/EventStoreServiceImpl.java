package ruiyin;/**
 * @author Weiyan Xiang on 2021/12/8
 */

import java.util.*;
import java.util.Map.Entry;

public class EventStoreServiceImpl implements EventStoreService {

    // Map: key is symbol ; value is treeMap -> key is the time ; value is the price;
    // floor/ceiling key to get the latest price
    private Map<String, TreeMap<Long, Double>> db;

    public EventStoreServiceImpl() {
        this.db = new HashMap<>();
    }

    @Override
    public void storeEvent(String symbol, double price, long time) {
        if (!db.containsKey(symbol)) {
            TreeMap<Long, Double> treeMap = new TreeMap<>();
            treeMap.put(time, price);
            db.put(symbol, treeMap);
        } else {
            db.get(symbol).put(time, price);
        }
    }

    @Override
    public double latestPriceAt(String symbol, long time) {
        return Optional.ofNullable(db.get(symbol)).map(e -> e.floorEntry(time)).map(Entry::getValue).orElse(null);
    }
}
