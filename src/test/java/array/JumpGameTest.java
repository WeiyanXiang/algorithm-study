package array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Weiyan Xiang on 2021/1/1
 */
public class JumpGameTest {

    @Test
    public void canJumpRec() {
        JumpGame testObj = new JumpGame();
        int [] nums = {2,3,1,1,4};
        assertTrue(testObj.canJumpRec(nums));
        int [] nums2 = {3,2,1,0,4};
        assertFalse(testObj.canJumpRec(nums2));
    }
}