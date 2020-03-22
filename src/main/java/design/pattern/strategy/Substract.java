package design.pattern.strategy;

/**
 * @author Weiyan Xiang on 2020/3/22
 */
public class Substract implements OperationStrategy {


    @Override
    public Integer apply(Integer a, Integer b) {
        return a - b;
    }
}
