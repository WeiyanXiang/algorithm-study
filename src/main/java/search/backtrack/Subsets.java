package search.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/5
 */
public class Subsets {

    /**
     * 78. Subsets
     * <p>
     * https://leetcode.com/problems/subsets/
     *
     * my AC answer
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return null;
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> cur, int start) {
        ans.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums, ans, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
