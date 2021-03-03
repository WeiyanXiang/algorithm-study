package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Weiyan Xiang on 2021/3/3
 */
public class SmallestStringWithSwapsTest {

    @Test
    public void smallestStringWithSwaps() {
        SmallestStringWithSwaps testObj = new SmallestStringWithSwaps();
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        // act
        String actual = testObj.smallestStringWithSwaps("dcab", pairs);
        // assert
        assertEquals("bacd", actual);

    }
}