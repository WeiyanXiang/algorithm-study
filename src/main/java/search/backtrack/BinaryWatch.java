package search.backtrack;/**
 * @author Weiyan Xiang on 2021/1/18
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    private int[] leds = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};

    /**
     * 401. Binary Watch
     * <p>
     * https://leetcode.com/problems/binary-watch/
     * <p>
     * %02d means an integer, left padded with zeros up to 2 digits.
     */
    public List<String> readBinaryWatchOptimal(int num) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return result;
    }

    /**
     * pass length 2 array for hour and min
     *
     * my ac answer
     */
    public List<String> readBinaryWatchRecursion(int num) {
        // C10 num permutation
        List<String> ans = new ArrayList<>();
        combinationsWithArray(10, num, new int[2], ans, 0);
        return ans;

    }

    private void combinationsWithArray(int n, int t, int[] cur, List<String> ans, int start) {
        if (t == 0) {
            if (cur[0] < 12 && cur[1] < 60) {
                ans.add(String.format("%d:%02d", cur[0], cur[1]));
            }
        }
        for (int i = start; i < n; i++) {
            int cd = leds[i];
            if (i > 3) {
                cur[1] += cd;
                combinationsWithArray(n, t - 1, cur, ans, i + 1);
                cur[1] -= cd;
            } else {
                cur[0] += cd;
                combinationsWithArray(n, t - 1, cur, ans, i + 1);
                cur[0] -= cd;
            }
        }
    }

    /**
     * pass hour and min individually
     */
    public List<String> readBinaryWatchWithInt(int num) {
        // C10 num permutation
        List<String> ans = new ArrayList<>();
        combinationsWithInt(10, num, 0, 0, ans, 0);
        return ans;

    }

    private void combinationsWithInt(int n, int t, int hour, int min, List<String> ans, int start) {
        if (t == 0) {
            if (hour < 12 && min < 60) {
                ans.add(String.format("%d:%02d", hour, min));
            }
        }
        for (int i = start; i < n; i++) {
            if (i > 3) combinationsWithInt(n, t - 1, hour, min + leds[i], ans, i + 1);
            else combinationsWithInt(n, t - 1, hour + leds[i], min, ans, i + 1);
        }
    }
}
