package search;/**
 * @author Weiyan Xiang on 2021/1/7
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionToKEqualSumSubsets {
    /**
     * 698. Partition to K Equal Sum Subsets
     * <p>
     * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        int dSum = sum / k;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        int l = 0, r = nums.length-1, target = dSum;
        while (l < r) {
            if (target < 0) return false;
            // add to bucket if matching
            if (target == 0) {
                list.add(bucket);
                bucket.clear();
                target = dSum;
            } else {
                bucket.add(nums[l]);
                target -= nums[l];
                l++;
            }
            target-=nums[r];
            bucket.add(nums[r]);
            r--;
        }
        return true;
    }
}
