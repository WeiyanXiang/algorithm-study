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
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }


    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) list.add(new ArrayList<>(tempList));
        else {
            for (int i = 0; i < nums.length; i++) {
                /**
                 * 如果已经加在path里了，跳过
                 */
                if (used[i]) continue;
                /**
                 * i > 0 && nums[i] == nums[i - 1] && !used.contains(i - 1)
                 * 意思是如果这个i的value和i-1一样，，并且i-1的value没有被用过，这样我们跳过去.
                 * 比如1a 1b 2a的path，在1b的时候，used【i-1】是true，所以不会被跳过去，因为我们不想减支
                 * 那么再次到1b 1a 2a的path，在1b的时候，used【i】是true所以跳过去。
                 * 再次到2a 1a 1b（第一次 2 1 1）的path，在1b的时候，used【i】还是false，所以不会被跳过去
                 * 再次到2a 1b 1a （第二次2 1 1）的path，在1b的时候，used【i】是true，所以跳过
                 */
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
