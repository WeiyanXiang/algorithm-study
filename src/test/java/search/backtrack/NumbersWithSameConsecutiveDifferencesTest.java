package search.backtrack;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Weiyan Xiang on 2021/1/30
 */
public class NumbersWithSameConsecutiveDifferencesTest {

    @Test
    public void numsSameConsecDiff() {
        NumbersWithSameConsecutiveDifferences testObj = new NumbersWithSameConsecutiveDifferences();
        // act
        int[] actual = testObj.numsSameConsecDiff(3, 7);
        // assert
        int[] expected = {181, 292, 707, 818, 929};
        assertArrayEquals(expected, actual);
    }
}