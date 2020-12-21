package search;/**
 * @author Weiyan Xiang on 2020/12/20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * this one is very similar to CombinationSumOne
 */
public class CombinationSumTwo {
    /***
     * 40. Combination Sum II
     *
     * https://leetcode.com/problems/combination-sum-ii/
     *
     * template answer, learnt from huahua
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, path, ans);
        return ans;
    }

    private void dfs(int[] nums, int start, int remain, List<Integer> path, List<List<Integer>> ans) {
        if (remain < 0) return;
        if (remain == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int n = nums[i];
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(n);
            // pass i+1 each time instead of i to indicate we don't use repeat nums in the array to construct the sum of target
            dfs(nums, i + 1, remain - n, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
