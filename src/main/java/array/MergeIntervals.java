package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/6/21
 */
public class MergeIntervals {

    /**
     * https://leetcode.com/problems/merge-intervals/
     * <p>
     * Example 1:
     * <p>
     * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6]
     * overlaps, merge them into [1,6]. Example 2:
     * <p>
     * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are considered overlapping. NOTE:
     * input types have been changed on April 15, 2019. Please reset to default code definition to get new method
     * signature.
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> ans = new ArrayList<>();
        int[] newInterval = intervals[0];
        ans.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1])
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {
                newInterval = interval;
                ans.add(newInterval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {5, 10},
                {11, 18},
        };

        int[][] merged = new MergeIntervals().merge(intervals);
        Arrays.stream(merged).forEach(e -> System.out.println(Arrays.toString(e)));
    }

}
