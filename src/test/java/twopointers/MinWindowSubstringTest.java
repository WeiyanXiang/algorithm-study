package twopointers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Weiyan Xiang on 2020/11/16
 */
public class MinWindowSubstringTest {

    MinWindowSubstring testObj = new MinWindowSubstring();

    @Test
    public void minWindow() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        // act
        // assert
        assertEquals("BANC", testObj.minWindow(s, t));
    }


}