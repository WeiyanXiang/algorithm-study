package design.pattern.strategy.lambda;

/**
 * @author Weiyan Xiang on 2020/3/22
 */
public class StrategyDemoLite {

    protected static final CalculationStrategy ADD = (a, b) -> a + b;
    protected static final CalculationStrategy SUBTRACT = (a, b) -> a - b;
    protected static final CalculationStrategy MULTIPLY = (a, b) -> a * b;

    public static void main(String[] args) {
        System.out.println(new SingleCalculator(ADD).doCalculate(1, 2));
        System.out.println(new SingleCalculator(SUBTRACT).doCalculate(1, 2));
        System.out.println(new SingleCalculator(MULTIPLY).doCalculate(1, 2));
    }


}
