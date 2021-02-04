package search.backtrack;/**
 * @author Weiyan Xiang on 2020/12/21
 */

import java.util.ArrayList;
import java.util.List;

public class CombinnationSumThree {

    /**
     * 216. Combination Sum III
     * <p>
     * https://leetcode.com/problems/combination-sum-iii/
     * <p>
     * my own ac annswer.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, n, temp, ans, 0, k);
        return ans;
    }

    private void dfs(int[] nums, int start, int remain, List<Integer> temp, List<List<Integer>> ans, int d, int k) {
        if (remain < 0) return;
        if (remain == 0 && d == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int n = nums[i];
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(n);
            dfs(nums, i + 1, remain - n, temp, ans, d + 1, k);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * dont need additional array, can be replaced with an array
     */
    public List<List<Integer>> combinationSum3Optimal(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(k, n, ans, cur, 1);
        return ans;
    }

    private void dfs(int k, int n, List<List<Integer>> ans, List<Integer> cur, int start) {
        if (n < 0) return;
        if (n == 0 && cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            dfs(k, n - i, ans, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
