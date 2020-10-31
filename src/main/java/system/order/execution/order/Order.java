package system.order.execution.order;

import system.order.execution.instrument.Instrument;

/**
 * @author Weiyan Xiang on 2020/10/31
 */
public final class Order {

    private final Instrument instrument;
    private final double price;
    private final long unit;
    private final OrderType orderType;

    public Order(Instrument instrument, double price, long unit, OrderType orderType) {
        this.instrument = instrument;
        this.price = price;
        this.unit = unit;
        this.orderType = orderType;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public double getPrice() {
        return price;
    }

    public long getUnit() {
        return unit;
    }

    public OrderType getOrderType() {
        return orderType;
    }
}
