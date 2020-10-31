package system.order.execution.book;

import system.order.execution.instrument.Instrument;
import system.order.execution.order.OrderType;

import java.util.Objects;

/**
 * @author Weiyan Xiang on 2020/10/31
 */
public class PositionRecord {

    private Instrument instrument;
    private double price;
    private long unit;
    private OrderType orderType;

    public PositionRecord(Instrument instrument, double price, long unit, OrderType orderType) {
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

    public void setUnit(long unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionRecord that = (PositionRecord) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(instrument, that.instrument) &&
                orderType == that.orderType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrument, price, orderType);
    }

    @Override
    public String toString() {
        return "price=" + price + ", total unit=" + unit + "\n";
    }
}
