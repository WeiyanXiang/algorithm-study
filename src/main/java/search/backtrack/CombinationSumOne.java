package search.backtrack;/**
 * @author Weiyan Xiang on 2020/12/20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * this one is same to the class in package: backtrack.CombinationSum
 */
public class CombinationSumOne {
    /**
     * 39. Combination Sum
     * <p>
     * https://leetcode.com/problems/combination-sum/
     *
     * template answer, learnt from huahua
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

            path.add(n);
            // pass i each time instead of i+1 to indicate we can have repeat nums to construct the sum of target
            dfs(nums, i, remain - n, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
