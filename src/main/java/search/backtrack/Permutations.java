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
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) list.add(new ArrayList<>(tempList));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
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
