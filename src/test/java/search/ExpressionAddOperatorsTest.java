package search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2021/1/11
 */
public class ExpressionAddOperatorsTest {

    @Test
    public void addOperators() {
        ExpressionAddOperators testObj = new ExpressionAddOperators();
        // act +-
        List<String> actualAddMinus = testObj.addOperators("1232", 4);
        // assert
        Assert.assertTrue(actualAddMinus.containsAll(Arrays.asList("1+2+3-2")));
    }
}