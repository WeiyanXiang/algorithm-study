package design.pattern.strategy;

/**
 * @author Weiyan Xiang on 2020/3/22
 * <p>
 * https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
 */
public class StrategyDemo {

    public static PaymentStrategy payPalPayment = payment -> {
        System.out.println("paypal payment");
        return payment;
    };

    /**
     * In Strategy pattern, a class behavior or its algorithm can be changed at run time. This type of design pattern
     * comes under behavior pattern.
     * <p>
     * In Strategy pattern, we create objects which represent various strategies and a context object whose behavior
     * varies as per its strategy object. The strategy object changes the executing algorithm of the context object.
     *
     * @param args
     */
    public static void main(String[] args) {
        Shopper shopper1 = new Shopper(new CashPayment());
        shopper1.makePayment(1);
        Shopper shopper2 = new Shopper(new CardPayment());
        shopper2.makePayment(2);
        Shopper shopper3 = new Shopper(payPalPayment);
        shopper3.makePayment(3);
    }
}
