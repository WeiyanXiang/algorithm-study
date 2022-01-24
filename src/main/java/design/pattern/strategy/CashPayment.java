package design.pattern.strategy;

/**
 * @author Weiyan Xiang on 2020/3/22
 */
public class CashPayment implements PaymentStrategy {

    @Override
    public Integer pay(Integer amount) {
        System.out.println("Cash payment");
        return amount;
    }
}
