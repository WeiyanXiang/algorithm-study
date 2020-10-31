package system.order.execution;

import org.junit.Test;
import system.order.execution.book.PositionRecord;
import system.order.execution.order.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static system.order.execution.instrument.Instrument.GOLD;
import static system.order.execution.order.OrderType.BUY;
import static system.order.execution.order.OrderType.SELL;

/**
 * @author Weiyan Xiang on 2020/10/31
 */
public class OrderBookManagerTest {

    OrderBookManager testObj = new OrderBookManager();
    //@formatter:off
    /**
     *     BUY 10 units at 8.88
     *     BUY 20 units at 9.99
     *
     *     SELL 5 units at 11.11
     *     BUY 5 units at 8.88
     *
     *     BUY 15 units at 9.01
     *     SELL 5 units at 10.01
     *
     *     BUY 30 units at 9.01
     *     SELL 5 units at 10.01
     */
    //@formatter:on
    @Test
    public void submit() {
        // act
        testObj.submit(new Order(GOLD, 8.88, 10, BUY));
        testObj.submit(new Order(GOLD, 9.99, 20, BUY));

        testObj.submit(new Order(GOLD, 11.11, 5, SELL));
        testObj.submit(new Order(GOLD, 8.88, 5, BUY));

        testObj.submit(new Order(GOLD, 9.01, 15, BUY));
        testObj.submit(new Order(GOLD, 10.01, 5, SELL));

        testObj.submit(new Order(GOLD, 9.01, 30, BUY));
        testObj.submit(new Order(GOLD, 10.01, 5, SELL));

        // print
        System.out.println("Buy side:");
        Collection<PositionRecord> buyBookPositions = testObj.getBuyBookPositions();
        List<PositionRecord> buyBookList = new ArrayList<>();
        buyBookList.addAll(buyBookPositions);
        System.out.println(buyBookList);

        System.out.println("Sell side:");
        Collection<PositionRecord> sellBookPositions = testObj.getSellBookPositions();
        List<PositionRecord> sellBookList = new ArrayList<>();
        sellBookList.addAll(sellBookPositions);
        System.out.println(sellBookList);

        // assert
        assertEquals(9.99, buyBookList.get(0).getPrice(), 0.0001);
        assertEquals(20, buyBookList.get(0).getUnit());
        assertEquals(9.01, buyBookList.get(1).getPrice(), 0.0001);
        assertEquals(45, buyBookList.get(1).getUnit());
        assertEquals(8.88, buyBookList.get(2).getPrice(), 0.0001);
        assertEquals(15, buyBookList.get(2).getUnit());

        assertEquals(10.01, sellBookList.get(0).getPrice(), 0.0001);
        assertEquals(10, sellBookList.get(0).getUnit());
        assertEquals(11.11, sellBookList.get(1).getPrice(), 0.0001);
        assertEquals(5, sellBookList.get(1).getUnit());

    }

}