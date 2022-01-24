package design.pattern.strategy.lambda;

/**
 * @author Weiyan Xiang on 2020/3/22
 */
public class SingleCalculator {
    private CalculationStrategy calculationStrategy;

    public SingleCalculator(CalculationStrategy strategy) {
        this.calculationStrategy = strategy;
    }

    public int doCalculate(int a, int b) {
        return calculationStrategy.calculate(a, b);
    }
}
