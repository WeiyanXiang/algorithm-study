package search.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/4
 */
public class CombinationSum {

    /**
     * 39. Combination Sum
     *
     * https://leetcode.com/problems/combination-sum/
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> cur, int[] cs, int target, int start) {
        if (target < 0) return;
        else if (target == 0) ans.add(new ArrayList<>(cur));
        else {
            for (int i = start; i < cs.length; i++) {
                cur.add(cs[i]);
                backtrack(ans, cur, cs, target - cs[i], i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
