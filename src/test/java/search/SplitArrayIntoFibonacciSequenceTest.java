package search;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Weiyan Xiang on 2021/1/12
 */
public class SplitArrayIntoFibonacciSequenceTest {

    @Test
    public void splitIntoFibonacci() {
        SplitArrayIntoFibonacciSequence testObj = new SplitArrayIntoFibonacciSequence();
        // act
        List<Integer> actual = testObj.splitIntoFibonacci("123456579");
        // assert
        assertTrue(actual.containsAll(Arrays.asList(123, 456, 579)));
    }
}