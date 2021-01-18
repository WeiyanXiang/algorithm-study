package search.backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Weiyan Xiang on 2021/1/18
 */
public class BinaryWatchTest {

    @Test
    public void readBinaryWatch() {
        BinaryWatch testObj = new BinaryWatch();
        // act
        List<String> actual = testObj.readBinaryWatchRecursion(1);
        // assert
        assertEquals(10, actual.size());
        assertTrue(actual.containsAll(Arrays.asList(
                "8:00", "4:00", "2:00", "1:00", "0:32", "0:16", "0:08", "0:04", "0:02", "0:01")));
    }
}