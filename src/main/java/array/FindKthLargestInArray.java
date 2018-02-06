/**
 * 
 */
package array;

import java.util.Arrays;

/**
 * @author weiyan.xiang
 * @date 5 Feb 2018
 */
public class FindKthLargestInArray {

    /**
     * take use of quick sort thinking to put nums that are <= pivot to the left
     * and put nums that are > pivot to the right
     * 
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] a, int k) {
        int n = a.length;
        if (k < n) {
            int i = quickSelect(a, 0, n - 1, n - k + 1);
            return a[i];
        }
        return -1;
    }

    /**
     * to do
     * 
     * @param a
     * @param i
     * @param j
     * @param k
     * @return
     */
    private static int quickSelect(int[] a, int l, int h, int k) {
        int pivot = a[h];
        int i = l, j = h;
        while (i < j) {
            if (a[i++] > pivot)
                swap(a, --i, --j);
        }
        swap(a, i, h);

        // count the nums that are <= pivot from lo
        int m = i - l + 1;

        // pivot is the one!
        if (m == k)
            return i;
        // pivot is too big, so it must be on the left
        else if (m > k)
            return quickSelect(a, l, i - 1, k);
        // pivot is too small, so it must be on the right
        else
            return quickSelect(a, i + 1, h, k - m);

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int findKthLargestNaive(int[] nums, int k) {
        if (k > nums.length - 1)
            return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 4, 5, 12, 15, 3, 7 };
        Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));
        System.out.println();
        System.out.println(findKthLargestNaive(arr, 12));
        System.out.println(findKthLargestNaive(arr, 2));
        System.out.println(findKthLargest(arr, 12));
        System.out.println(findKthLargest(arr, 2));
    }
}
