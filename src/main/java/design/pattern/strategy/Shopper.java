package design.pattern.strategy;

/**
 * @author Weiyan Xiang on 2022/1/24
 */

public class Shopper {
    private PaymentStrategy strategy;

    public Shopper(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public int makePayment(int amount) {
        return strategy.pay(amount);
    }

}
