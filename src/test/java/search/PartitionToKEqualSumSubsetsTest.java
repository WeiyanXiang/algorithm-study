package search;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Weiyan Xiang on 2021/1/7
 */
public class PartitionToKEqualSumSubsetsTest {

    @Test
    public void canPartitionKSubsets() {
        PartitionToKEqualSumSubsets testObj = new PartitionToKEqualSumSubsets();
        // act
        assertTrue(testObj.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}