package array;

import java.util.Arrays;

/**
 * @author Weiyan Xiang on 2020/6/23
 */
public class MeetingRooms {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * determine if a person could attend all meetings.
     * <p>
     * For example,
     * <p>
     * Given [[0, 30],[5, 10],[15, 20]], return false.
     * <p>
     * Solution
     * <p>
     * The idea is pretty simple: first we sort the intervals in the ascending order of start; then we check for the
     * overlapping of each pair of neighboring intervals. If they do, then return false; after we finish all the checks
     * and have not returned false, just return true.
     * <p>
     * Sorting takes O(nlogn) time and the overlapping checks take O(n) time, so this idea is O(nlogn) time in total.
     */
    public boolean canAttend(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {0, 30},
                {5, 10},
                {15, 20},
        };
        int[][] another = {
                {0, 5},
                {15, 30},
                {6, 10},
        };


        System.out.println(new MeetingRooms().canAttend(intervals));
        System.out.println(new MeetingRooms().canAttend(another));
    }
}
