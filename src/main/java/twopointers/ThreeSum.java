package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/4
 */
public class ThreeSum {

    /**
     * https://leetcode.com/problems/3sum/submissions/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1, target = -nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < target) l++;
                else if (sum > target) r--;
                else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // Processing duplicates of Number 2
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    // Processing duplicates of Number 3
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
            }
            // Processing duplicates of Number 1
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }
}
