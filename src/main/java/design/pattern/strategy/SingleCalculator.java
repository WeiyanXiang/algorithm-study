package design.pattern.strategy;

/**
 * @author Weiyan Xiang on 2020/3/22
 */
public class SingleCalculator {
    private OperationStrategy strategy;

    public SingleCalculator(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public int doCalculate(int a, int b) {
        return strategy.execute(a, b);
    }
}
