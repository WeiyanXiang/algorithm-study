package twopointers;

/**
 * @author Weiyan Xiang on 2020/11/21
 */
public class TrappingRainWater {
    /**
     * https://leetcode.com/problems/trapping-rain-water/
     * <p>
     * 42. Trapping Rain Water
     */
    public int trap(int[] h) {
        int n = h.length;
        if (h.length == 0) return 0;
        int l = 0, r = n - 1;
        int maxL = h[l], maxR = h[r];
        int ans = 0;
        while (l < r) {
            if (h[l] < h[r]) {
                ans += maxL - h[l];
                l++;
                maxL = Math.max(maxL, h[l]);
            } else {
                ans += maxR - h[r];
                r--;
                maxR = Math.max(maxR, h[r]);
            }
        }
        return ans;
    }
}
