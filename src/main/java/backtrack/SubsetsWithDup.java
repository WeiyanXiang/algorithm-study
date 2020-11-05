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
