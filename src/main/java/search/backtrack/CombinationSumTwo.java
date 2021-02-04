package search.backtrack;/**
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

    private void dfs(int[] cs, int start, int target, List<Integer> cur, List<List<Integer>> ans) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < cs.length; i++) {
            int n = cs[i];
            // if there is a solution like there are two 1 in cs and the solution 1,1,6 should be picked up once
            if (i > start && cs[i] == cs[i - 1]) continue;
            cur.add(n);
            // pass i+1 each time instead of i to indicate we don't use repeat cs in the array
            dfs(cs, i + 1, target - n, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
