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
     * and put nums that are > pivot to the right, take end element as pivot
     * each time
     * 
     * @param arr
     * @param k
     * @return
     */
    private static int findKthLargest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, arr.length - k);
    }

    private static int quickSelect(int[] arr, int l, int r, int k) {
        if (l <= r && l <= k && k <= r) {
            int p = partition(arr, l, r);
            if (p == k) {
                return arr[p];
            } else if (p < k) {
                return quickSelect(arr, p + 1, r, k);
            } else {
                return quickSelect(arr, l, p - 1, k);
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;
        for (int m = i; m <= r - 1; m++) {
            if (arr[m] < pivot) {
                int temp = arr[m];
                arr[m] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        return i;
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
