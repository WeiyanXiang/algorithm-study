package ruiyin;/**
 * @author Weiyan Xiang on 2021/12/8
 */

public interface EventStoreService {

    public void storeEvent(String symbol, double price, long time);

    public double latestPriceAt(String symbol, long time);

}

