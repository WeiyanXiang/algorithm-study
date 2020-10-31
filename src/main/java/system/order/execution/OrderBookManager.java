package system.order.execution;

import system.order.execution.book.OrderBook;
import system.order.execution.book.PositionRecord;
import system.order.execution.order.Order;

import java.util.Collection;

/**
 * @author Weiyan Xiang on 2020/10/31
 */
public class OrderBookManager {

    private OrderBook orderBook;

    public OrderBookManager() {
        this.orderBook = new OrderBook();
    }

    public void submit(Order order) {
        PositionRecord positionRecord = new PositionRecord(order.getInstrument(), order.getPrice(), order.getUnit(), order.getOrderType());
        orderBook.submit(positionRecord);
    }

    public Collection<PositionRecord> getBuyBookPositions() {
        return orderBook.getBuyBook().values();
    }

    public Collection<PositionRecord> getSellBookPositions() {
        return orderBook.getSellBook().values();
    }

}
