package search.backtrack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2021/1/3
 */
public class PermutationsTwoTest {

    @Test
    public void permuteUnique() {
        PermutationsTwo testObj = new PermutationsTwo();
        int[] nums = {1, 1, 2};
        // act
        List<List<Integer>> actual = testObj.permuteUnique(nums);
        // assert
        Assert.assertEquals(3, actual.size());
        Assert.assertTrue(actual.containsAll(Arrays.asList(
                Arrays.asList(1, 1, 2),
                Arrays.asList(1, 2, 1),
                Arrays.asList(2, 1, 1)
        )));
    }
}