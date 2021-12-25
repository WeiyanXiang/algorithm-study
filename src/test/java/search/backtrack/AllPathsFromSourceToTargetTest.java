package search.backtrack;

import graph.AllPathsFromSourceToTarget;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals(2, actual.size());
        assertTrue(actual.contains(Arrays.asList(0, 1, 3)));
        assertTrue(actual.contains(Arrays.asList(0, 2, 3)));
    }

    @Test
    public void allPathsSourceTargetMyAc() {
        AllPathsFromSourceToTarget testObj = new AllPathsFromSourceToTarget();
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        // act
        List<List<Integer>> actual = testObj.allPathsSourceTargetMyAc(graph);
        // assert
        assertEquals(2, actual.size());
        assertTrue(actual.contains(Arrays.asList(0, 1, 3)));
        assertTrue(actual.contains(Arrays.asList(0, 2, 3)));
    }
}