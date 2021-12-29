package twopointers;/**
 * @author Weiyan Xiang on 2021/12/29
 */

import java.util.*;

public class TriangleNumber {
    /**
     * 611. Valid Triangle Number
     * <p>
     * https://leetcode.com/problems/valid-triangle-number/
     * <p>
     * upvoted ans, similar to 3Sum, start from tail of array
     */
    public int triangleNumber(int[] nums) {
        // two pointers, to put first 2 into cur array
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                // if valid triangle
                if (nums[l] + nums[r] > nums[i]) {
                    // because i.e. 2,3,4,5,6 when 2,5 and 6 in comparison, it is valid then the further 3,4 in array
                    // must work too since they are greater than 2 in sorted array
                    count += r - l;
                    r--;
                } else l++;
            }
        }
        return count;
    }


    /**
     * same idea, forward looping
     */
    public int triangleNumberForwardLooping(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                // if valid triangle
                if (nums[l] + nums[r] > nums[i]) {
                    count += r - l;
                    r--;
                } else l++;
            }
        }
        return count;
    }
}
