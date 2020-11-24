package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Weiyan Xiang on 2020/11/24
 */
public class SubarraysWithKDifferentIntegers {
    /**
     * Let f(x) denote the number of subarrays with x or less distinct numbers. ans = f(K) – f(K-1)
     **/
    /**
     * 992. Subarrays with K Different Integers
     * <p>
     * https://leetcode.com/problems/subarrays-with-k-different-integers/
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K - 1);
    }

    private int atMost(int[] a, int k) {
        int l = 0, r = 0, count = 0, res = 0;
        Map<Integer, Integer> win = new HashMap<>();
        while (r < a.length) {
            win.put(a[r], win.getOrDefault(a[r], 0) + 1);
            if (win.get(a[r]) == 1) count++;
            r++;
            while (l < r && count > k) {
                if (win.get(a[l]) == 1) {
                    win.remove(a[l]);
                    count--;
                } else {
                    win.put(a[l], win.get(a[l]) - 1);
                }
                l++;
            }
            res += r - l;
        }
        return res;
    }
}
