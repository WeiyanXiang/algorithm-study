package search;/**
 * @author Weiyan Xiang on 2021/1/7
 */

public class PartitionToKEqualSumSubsets {
    /**
     * 698. Partition to K Equal Sum Subsets
     * <p>
     * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
     *
     * upvoted ans
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int target = sum / k;
        if (sum % k != 0) return false;
        if (max > target) return false;
        return dfs(nums, k, new boolean[nums.length], target, 0, 0);
    }

    private boolean dfs(int[] nums, int k, boolean[] visited, int target, int cur, int start) {
        if (k == 0) return true;
        if (target == cur) return dfs(nums, k - 1, visited, target, 0, 0);
        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && nums[i] + cur <= target) {
                visited[i] = true;
                if (dfs(nums, k, visited, target, cur + nums[i], i + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
