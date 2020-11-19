package twopointers;

/**
 * @author Weiyan Xiang on 2020/11/3
 */
public class ContainerWithMostWater {

    /**
     * 11. Container With Most Water
     * <p>
     * https://leetcode.com/problems/container-with-most-water/
     */
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1, ans = 0;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

}
