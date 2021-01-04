package search;

import org.junit.Assert;
import org.junit.Test;

import static java.util.Arrays.asList;

/**
 * @author Weiyan Xiang on 2021/1/4
 */
public class CutOffTreesTest {

    @Test
    public void cutOffTree() {
        CutOffTrees testObj = new CutOffTrees();
        Assert.assertEquals(6, testObj.cutOffTree(asList(asList(1, 2, 3), asList(0, 0, 4), asList(7, 6, 5))));
//        Assert.assertEquals(6, testObj.cutOffTree(asList(asList(2, 3, 4), asList(0, 0, 5), asList(8, 7, 6))));
//        Assert.assertEquals(-1, testObj.cutOffTree(asList(asList(1, 2, 3), asList(0, 0, 0), asList(7, 6, 5))));
//        Assert.assertEquals(17, testObj.cutOffTree(asList(asList(3, 4, 5), asList(0, 0, 6), asList(2, 8, 7))));
    }
}