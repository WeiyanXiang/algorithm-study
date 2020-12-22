package search.backtrack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Weiyan Xiang on 2020/12/22
 */
public class ShortestSuperstringTest {

    @Test
    public void shortestSuperstring() {
        ShortestSuperstring testObj = new ShortestSuperstring();
        String[] A = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"};
        // act
        Assert.assertEquals("gctaagttcatgcatc", testObj.shortestSuperstring(A));
    }
}