package design.pattern.strategy;

/**
 * @author Weiyan Xiang on 2020/3/22
 */
public class Substract implements OperationStrategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}
