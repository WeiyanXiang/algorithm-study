package search.backtrack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/5
 */
public class SubsetsTest {

    @Test
    public void testSubsets() {
        Subsets testObj = new Subsets();
        int[] nums = {1, 2, 3};
        // act
        List<List<Integer>> actual = testObj.subsets(nums);
        // assert
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(3));
        Assert.assertEquals(expected, actual);
    }

}