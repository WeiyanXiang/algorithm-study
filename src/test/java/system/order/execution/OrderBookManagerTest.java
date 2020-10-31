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
     *     BUY 10 units at 12.23
     *     BUY 20 units at 12.31
     *
     *     SELL 5 units at 13.55
     *     BUY 5 units at 12.23
     *
     *     BUY 15 units at 12.25
     *     SELL 5 units at 13.31
     *
     *     BUY 30 units at 12.25
     *     SELL 5 units at 13.31
     */
    //@formatter:on
    @Test
    public void submit() {
        // act
        testObj.submit(new Order(GOLD, 12.23, 10, BUY));
        testObj.submit(new Order(GOLD, 12.31, 20, BUY));

        testObj.submit(new Order(GOLD, 13.55, 5, SELL));
        testObj.submit(new Order(GOLD, 12.23, 5, BUY));

        testObj.submit(new Order(GOLD, 12.25, 15, BUY));
        testObj.submit(new Order(GOLD, 13.31, 5, SELL));

        testObj.submit(new Order(GOLD, 12.25, 30, BUY));
        testObj.submit(new Order(GOLD, 13.31, 5, SELL));

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
        assertEquals(12.31, buyBookList.get(0).getPrice(), 0.0001);
        assertEquals(20, buyBookList.get(0).getUnit());
        assertEquals(12.25, buyBookList.get(1).getPrice(), 0.0001);
        assertEquals(45, buyBookList.get(1).getUnit());
        assertEquals(12.23, buyBookList.get(2).getPrice(), 0.0001);
        assertEquals(15, buyBookList.get(2).getUnit());

        assertEquals(13.31, sellBookList.get(0).getPrice(), 0.0001);
        assertEquals(10, sellBookList.get(0).getUnit());
        assertEquals(13.55, sellBookList.get(1).getPrice(), 0.0001);
        assertEquals(5, sellBookList.get(1).getUnit());

    }

}