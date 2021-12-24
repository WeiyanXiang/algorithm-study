package slidingwindow;/**
 * @author Weiyan Xiang on 2021/12/19
 */

import java.util.*;

public class MinDistanceTwoNumbers {

    /**
     * Find the minimum distance between two numbers
     *
     * Input:
     * arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3},
     * x = 3, y = 6
     * Output: Minimum distance between 3
     * and 6 is 4.
     * Explanation:3 is at index 0 and 6 is at
     * index 5, so the distance is 4
     *
     * Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3},
     * x = 3, y = 2
     * Output: Minimum distance between 3
     * and 2 is 1.
     * Explanation:3 is at index 7 and 2 is at
     * index 6, so the distance is 1
     *
     * my ac ans: sliding window
     */
    public int minDistance(int[] arr, int x, int y) {
        int l = 0, r = 0, min = Integer.MAX_VALUE;
        while (r < arr.length) {
            if (arr[r] == x) {
                while (l < r) {
                    if (arr[l] == y) min = Math.min(min, Math.abs(l - r));
                    l++;
                }
            } else if (arr[r] == y) {
                while (l < r) {
                    if (arr[l] == x) min = Math.min(min, Math.abs(l - r));
                    l++;
                }
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        MinDistanceTwoNumbers minD = new MinDistanceTwoNumbers();
        System.out.println(minD.minDistance(arr1, 3, 6) + " == 4");
        int[] arr2 = {2, 5, 3, 5, 4, 4, 2, 3};
        System.out.println(minD.minDistance(arr2, 3, 2) + " == 1");
        System.out.println(minD.minDistance(arr2, 8, 2) + " == -1");

    }
}
