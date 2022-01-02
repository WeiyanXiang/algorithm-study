package array;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Weiyan Xiang on 2022/1/2
 */
public class TravelerFundTest {
    @Test
    public void testCanStart() {
        TravelerFund testObj = new TravelerFund();
        MatcherAssert.assertThat(testObj.startWithFund(new int[]{3, 4, 2, -3}), is(0));
        MatcherAssert.assertThat(testObj.startWithFund(new int[]{3, -2, -3, -3, -7, 8, 1}), is(12));
    }
}