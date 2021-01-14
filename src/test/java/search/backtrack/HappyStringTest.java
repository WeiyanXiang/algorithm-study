package search.backtrack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Weiyan Xiang on 2021/1/14
 */
public class HappyStringTest {

    @Test
    public void getHappyString() {
        HappyString testObj = new HappyString();
        // act
        assertEquals("c", testObj.getHappyString(3,3));
//        assertEquals("abacbabacb", testObj.getHappyString(10,100));
    }
}