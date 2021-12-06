package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Weiyan Xiang on 2020/6/23
 */
public class MeetingRoomsTwo {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
     * <p>
     * find the minimum number of conference rooms required.
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>(intervals.length);
        int count = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (heap.isEmpty()) {
                count++;
                heap.offer(intervals[i][1]);
            } else {
                if (intervals[i][0] >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }
                heap.offer(intervals[i][1]);
            }
        }
        return count;
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


        System.out.println(new MeetingRoomsTwo().minMeetingRooms(intervals));
        System.out.println(new MeetingRoomsTwo().minMeetingRooms(another));
    }
}
