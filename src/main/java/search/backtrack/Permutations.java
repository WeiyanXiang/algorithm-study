package search.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Weiyan Xiang on 2020/11/5
 */
public class Permutations {

    /**
     * 46. Permutations
     * <p>
     * https://leetcode.com/problems/permutations/
     * <p>
     * I think contains is costly and found second method using additional set from the answer's comments
     * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) ans.add(new ArrayList<>(cur));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (cur.contains(nums[i])) continue;
                cur.add(nums[i]);
                backtrack(ans, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }


    public List<List<Integer>> permuteWithSet(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrackWithSet(list, new ArrayList<>(), new HashSet<>(), nums);
        return list;
    }

    private void backtrackWithSet(List<List<Integer>> list, List<Integer> tempList, Set<Integer> tempSet, int[] nums) {
        if (tempList.size() == nums.length) list.add(new ArrayList<>(tempList));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (tempSet.contains(nums[i])) continue;
                tempSet.add(nums[i]);
                tempList.add(nums[i]);

                backtrackWithSet(list, tempList, tempSet, nums);

                tempSet.remove(tempList.get(tempList.size() - 1));
                tempList.remove(tempList.size() - 1);

            }
        }
    }
}
