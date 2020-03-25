package design.pattern.strategy.lambda;

import design.pattern.strategy.SingleCalculator;

import java.util.function.BiFunction;

/**
 * @author Weiyan Xiang on 2020/3/22
 */
public class StrategyDemoLite {

    protected static final BiFunction<Integer, Integer, Integer> ADD = (a, b) -> a + b;
    protected static final BiFunction<Integer, Integer, Integer> SUBSTRACT = (a, b) -> a - b;
    protected static final BiFunction<Integer, Integer, Integer> MULTIPLY = (a, b) -> a * b;

    public static void main(String[] args) {
        SingleCalculator doAdd = new SingleCalculator(ADD);
        SingleCalculator doMinus = new SingleCalculator(SUBSTRACT);
        SingleCalculator doMulti = new SingleCalculator(MULTIPLY);

        System.out.println(doAdd.doCalculate(1, 2));
        System.out.println(doMinus.doCalculate(1, 2));
        System.out.println(doMulti.doCalculate(1, 2));
    }


}
