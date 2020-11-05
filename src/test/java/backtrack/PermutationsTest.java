package backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        List<List<Integer>> actual = new ArrayList<>();
        actual.add(Arrays.asList(1, 2, 3));
        actual.add(Arrays.asList(1, 3, 2));
        actual.add(Arrays.asList(2, 1, 3));
        actual.add(Arrays.asList(2, 3, 1));
        actual.add(Arrays.asList(3, 1, 2));
        actual.add(Arrays.asList(3, 2, 1));
        assertEquals(expected, actual);
    }
}