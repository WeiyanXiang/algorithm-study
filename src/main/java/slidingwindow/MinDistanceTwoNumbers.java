package slidingwindow;/**
 * @author Weiyan Xiang on 2021/12/19
 */

import java.util.*;

public class MinDistanceTwoNumbers {

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
