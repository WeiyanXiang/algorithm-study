package search.backtrack;/**
 * @author Weiyan Xiang on 2020/12/21
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsTwo {
    /**
     * 47. Permutations II
     * <p>
     * https://leetcode.com/problems/permutations-ii/
     * <p>
     * ac answer:
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }


    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) ans.add(new ArrayList<>(cur));
        else {
            for (int i = 0; i < nums.length; i++) {
                /**
                 * 如果已经加在path里了，跳过
                 */
                if (used[i]) continue;
                /**
                 * i > 0 && nums[i] == nums[i - 1] && !used.contains(i - 1)
                 * 如果之前i-1已经被handle过了，continue
                 */
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue;
                used[i] = true;
                cur.add(nums[i]);
                backtrack(nums, ans, cur, used);
                used[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
