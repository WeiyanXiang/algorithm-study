package design.pattern.strategy;

import java.util.function.BiFunction;

/**
 * @author Weiyan Xiang on 2020/3/22
 */
public interface PaymentStrategy {
    Integer pay(Integer amount);
}
