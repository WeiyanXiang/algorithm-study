package twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/22
 */
public class IntervalListIntersections {
    /**
     * 986. Interval List Intersections
     * <p>
     * https://leetcode.com/problems/interval-list-intersections/
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int a = 0, b = 0;
        List<int[]> ans = new ArrayList<>();
        while (a < A.length && b < B.length) {
            int start = Math.max(A[a][0], B[b][0]);
            int end = Math.min(A[a][1], B[b][1]);
            if (start <= end) ans.add(new int[]{start, end});
            if (A[a][1] < B[b][1]) a++;
            else b++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
