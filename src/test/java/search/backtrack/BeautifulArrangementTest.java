package search.backtrack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Weiyan Xiang on 2021/1/25
 */
public class BeautifulArrangementTest {

    @Test
    public void countArrangement() {
        BeautifulArrangement testObj = new BeautifulArrangement();
        // act
        int actual = testObj.countArrangement(3);
        // assert
        assertEquals(3, actual);
    }
}