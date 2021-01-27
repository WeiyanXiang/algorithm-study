package search.backtrack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2021/1/27
 */
public class AllPathsFromSourceToTargetTest {

    @Test
    public void allPathsSourceTarget() {
        AllPathsFromSourceToTarget testObj = new AllPathsFromSourceToTarget();
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        // act
        List<List<Integer>> actual = testObj.allPathsSourceTarget(graph);
        // assert
        Assert.assertEquals(2, actual.size());
        Assert.assertTrue(actual.contains(Arrays.asList(0, 1, 3)));
        Assert.assertTrue(actual.contains(Arrays.asList(0, 2, 3)));

    }
}