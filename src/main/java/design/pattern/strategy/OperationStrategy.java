package design.pattern.strategy;

import java.util.function.BiFunction;

/**
 * @author Weiyan Xiang on 2020/3/22
 */
public interface OperationStrategy extends BiFunction<Integer, Integer, Integer> {
    @Override
    Integer apply(Integer a, Integer b);
}
