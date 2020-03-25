package design.pattern.strategy;

import java.util.function.BiFunction;

/**
 * @author Weiyan Xiang on 2020/3/22
 */
public class SingleCalculator {
    private BiFunction<Integer, Integer, Integer> strategy;

    public SingleCalculator(BiFunction<Integer, Integer, Integer> strategy) {
        this.strategy = strategy;
    }

    public int doCalculate(int a, int b) {
        return strategy.apply(a, b);
    }
}
