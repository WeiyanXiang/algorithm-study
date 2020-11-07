package backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Weiyan Xiang on 2020/11/5
 */
public class PermutationsTest {
    private Permutations testObj = new Permutations();

    @Test
    public void permute() {
        int[] nums = {1, 2, 3};
        // act
        List<List<Integer>> expected = testObj.permute(nums);
        // assert
        List<Integer> p1 = Arrays.asList(1, 2, 3);
        List<Integer> p2 = Arrays.asList(1, 3, 2);
        List<Integer> p3 = Arrays.asList(2, 1, 3);
        List<Integer> p4 = Arrays.asList(2, 3, 1);
        List<Integer> p5 = Arrays.asList(3, 1, 2);
        List<Integer> p6 = Arrays.asList(3, 2, 1);
        assertEquals(6, expected.size());
        assertTrue(expected.contains(p1));
        assertTrue(expected.contains(p2));
        assertTrue(expected.contains(p3));
        assertTrue(expected.contains(p4));
        assertTrue(expected.contains(p5));
        assertTrue(expected.contains(p6));

    }
}