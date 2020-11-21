package twopointers;

/**
 * @author Weiyan Xiang on 2020/11/21
 */
public class SquaresOfSortedArray {
    /**
     * 977. Squares of a Sorted Array
     * <p>
     * https://leetcode.com/problems/squares-of-a-sorted-array/
     */
    public int[] sortedSquares(int[] a) {
        int[] ans = new int[a.length];
        int l = 0, r = a.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (Math.abs(a[l]) > Math.abs(a[r])) {
                ans[i] = a[l] * a[l];
                l++;
            } else {
                ans[i] = a[r] * a[r];
                r--;
            }
        }
        return ans;
    }
}
