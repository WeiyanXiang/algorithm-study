package array;

/**
 * @author Weiyan Xiang on 2020/6/21
 */
public class FindOccurenceInSortedArray {

    /**
     * Given a sorted array of n elements, possibly with duplicates, find the number of occurrences of the target
     * element.
     * <p>
     * Example 1:
     * <p>
     * Input: arr = [4, 4, 8, 8, 8, 15, 16, 23, 23, 42], target = 8 Output: 3
     * <p>
     * Example 2:
     * <p>
     * Input: arr = [3, 5, 5, 5, 5, 7, 8, 8], target = 6 Output: 0
     * <p>
     * Example 3:
     * <p>
     * Input: arr = [3, 5, 5, 5, 5, 7, 8, 8], target = 5 Output: 4
     * <p>
     * Expected O(logn) time solution.
     * <p>
     * Related problems:
     * <p>
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
     */
    public int count(int[] a, int t) {
        int left = binarySearch(a, t, true);
        if (left < 0) return 0;
        int right = binarySearch(a, t, false);
        return right - left + 1;
    }

    private int binarySearch(int[] a, int t, boolean leftMost) {
        int l = 0, r = a.length - 1, res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (t < a[mid]) {
                r = mid - 1;
            } else if (t > a[mid]) {
                l = mid + 1;
            } else {
                res = mid;
                if (leftMost) r = mid - 1;
                else l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindOccurenceInSortedArray testObj = new FindOccurenceInSortedArray();
        int[] a = {4, 4, 8, 8, 8, 15, 16, 23, 23, 42};
        System.out.println(testObj.count(a, 8) + " == 3");
    }


}
