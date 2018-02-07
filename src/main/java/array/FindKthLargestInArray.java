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
        return quickSelect(a, 0, a.length - 1, a.length - k);
    }

    private static int quickSelect(int[] a, int l, int r, int k) {
        if (k < r - l + 1 && k > 0) {
            int p = partition(a, l, r);
            if (p == k) {
                return a[k];
            } else if (p < k) {
                return quickSelect(a, p + 1, r, k);
            } else {
                return quickSelect(a, l, p - 1, k);
            }
        }
        return -1;
    }

    /**
     * to do
     * 
     * @param a
     * @param i
     * @param j
     * @return
     */
    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;
        for (int j = l; j <= r - 1; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        return i;
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
