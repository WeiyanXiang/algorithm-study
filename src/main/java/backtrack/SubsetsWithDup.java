package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/5
 */
public class SubsetsWithDup {

    /**
     * https://leetcode.com/problems/subsets-ii/
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    /**
     * The difficulty is to handle the duplicates. With inputs as [1a, 1b, 2a], If we don't handle the duplicates, the
     * results would be: [1a, 1b, 2a], [1b, 1a, 2a]..., so we must make sure 1a goes before 1b to avoid duplicates By
     * using nums[i-1]==nums[i] && !used[i-1], we can make sure that 1b cannot be choosed before 1a
     */
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
