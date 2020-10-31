package system.order.execution.book;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Weiyan Xiang on 2020/10/31
 */
public class OrderBook {

    private TreeMap<Double, PositionRecord> buyBook;
    private TreeMap<Double, PositionRecord> sellBook;

    class BuyOrderComparator implements Comparator<PositionRecord> {
        @Override
        public int compare(PositionRecord p1, PositionRecord p2) {
            if (p1.getPrice() > p2.getPrice()) {
                return -1;
            }
            if (p1.getPrice() > p2.getPrice()) {
                return 1;
            }
            return 0;
        }
    }

    class SellOrderComparator implements Comparator<PositionRecord> {
        @Override
        public int compare(PositionRecord p1, PositionRecord p2) {
            if (p1.getPrice() > p2.getPrice()) {
                return 1;
            }
            if (p1.getPrice() > p2.getPrice()) {
                return -1;
            }
            return 0;
        }
    }


    public OrderBook() {
        this.buyBook = new TreeMap<>(Collections.reverseOrder());
        this.sellBook = new TreeMap<>();
    }

    public void submit(PositionRecord positionRecord) {
        switch (positionRecord.getOrderType()) {
            case BUY:
                if (buyBook.containsKey(positionRecord.getPrice())) {
                    PositionRecord currentRecord = buyBook.get(positionRecord.getPrice());
                    currentRecord.setUnit(positionRecord.getUnit() + currentRecord.getUnit());
                } else {
                    buyBook.put(positionRecord.getPrice(), positionRecord);
                }
                break;
            case SELL:
            default:
                if (sellBook.containsKey(positionRecord.getPrice())) {
                    PositionRecord currentRecord = sellBook.get(positionRecord.getPrice());
                    currentRecord.setUnit(positionRecord.getUnit() + currentRecord.getUnit());
                } else {
                    sellBook.put(positionRecord.getPrice(), positionRecord);
                }
                break;
        }
    }

    public void printBook() {
        System.out.println("Buy Book:");
        System.out.println(buyBook);
        System.out.println("Sell Book:");
        System.out.println(sellBook);
    }

    public Map<Double, PositionRecord> getBuyBook() {
        return buyBook;
    }

    public Map<Double, PositionRecord> getSellBook() {
        return sellBook;
    }
}
