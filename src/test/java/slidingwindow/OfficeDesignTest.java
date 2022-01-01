package slidingwindow;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * @author Weiyan Xiang on 2022/1/1
 */
public class OfficeDesignTest {
    @Test
    public void testMaxColors() {
        OfficeDesign testObj = new OfficeDesign();
        assertThat(testObj.getMaxColors(new int[]{2, 3, 5, 1, 1, 2, 1}, 7), CoreMatchers.is(4));
        assertThat(testObj.getMaxColors(new int[]{2, 3, 5, 1, 2, 1}, 7), CoreMatchers.is(3));
        assertThat(testObj.getMaxColors(new int[]{2, 3, 5, 1, 2, 1, 2, 3, 1}, 6), CoreMatchers.is(4));
    }
}