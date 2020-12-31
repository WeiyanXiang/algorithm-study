package search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Weiyan Xiang on 2020/12/31
 */
public class OpenTheLockTest {
    @Test
    public void testOpenLock() {
        OpenTheLock testObj = new OpenTheLock();
        // act
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        assertEquals(6, testObj.openLock(deadends, target));

        String[] deadends2 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target2 = "8888";
        assertEquals(-1, testObj.openLock(deadends2, target2));
    }
}