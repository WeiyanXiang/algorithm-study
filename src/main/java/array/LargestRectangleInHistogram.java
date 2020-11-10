package array;

import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/11/10
 */
public class LargestRectangleInHistogram {

    /**
     * 84. Largest Rectangle in Histogram
     * <p>
     * https://leetcode.com/problems./largest-rectangle-in-histogram/
     */
    public int largestRectangleArea(int[] h) {
        if (h == null || h.length == 0) return 0;
        int[] lessFromLeft = new int[h.length];
        int[] lessFromRight = new int[h.length];
        lessFromLeft[0] = -1;
        lessFromRight[h.length - 1] = h.length;
        for (int i = 0; i < h.length; i++) {
            int p = i - 1;
            while (p >= 0 && h[p] >= h[i]) p = lessFromLeft[p];
            lessFromLeft[i] = p;
        }
        for (int j = h.length - 1; j >= 0; j--) {
            int p = j + 1;
            while (p < h.length && h[p] >= h[j]) p = lessFromRight[p];
            lessFromRight[j] = p;
        }
        int ans = 0;
        for (int i = 0; i < h.length; i++) {
            ans = Math.max(ans, (lessFromRight[i] - lessFromLeft[i] - 1) * h[i]);
        }
        return ans;
    }

    /**
     * below is draft of
     * <p>
     * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28917/AC-Python-clean-solution-using-stack-76ms
     */
    public int largestRectangleAreaWithStack(int[] heights) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] h = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            h[i] = heights[i];
        }
        h[heights.length] = 0;
        int ans = 0;
        for (int i = 0; i < h.length; i++) {
            while (h[i] <= h[s.peek()]) {
                int w = s.pop() - i - 1;
                int hi = h[i];
                ans = Math.max(ans, w * hi);
            }
            s.push(i);
        }
        return ans;
    }

}
