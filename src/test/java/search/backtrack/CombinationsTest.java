package search.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Weiyan Xiang on 2020/12/23
 */
public class CombinationsTest {

    @Test
    public void combine() {

        Combinations testObj= new Combinations();
        // act
        List<List<Integer>> actual = testObj.combine(3, 2);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1,2));
        expected.add(Arrays.asList(1,3));
        expected.add(Arrays.asList(2,3));

        assertTrue(actual.containsAll(expected));
    }
}