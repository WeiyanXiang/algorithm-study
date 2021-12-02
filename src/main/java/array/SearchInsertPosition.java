/**
 *
 */
package array;

/**
 * @author weiyan.xiang
 * @date 19 Feb 2018
 */
public class SearchInsertPosition {
    /**
     * Given a sorted array and a target value, return the index if the target
     * is found. If not, return the index where it would be if it were inserted
     * in order.
     *
     * Example 1:
     *
     * Input: [1,3,5,6], 5 Output: 2
     *
     * Example 2:
     *
     * Input: [1,3,5,6], 2 Output: 1
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertBinarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }

    public static int searchInsert(int[] nums, int target) {
        return binarySearchInsert(nums, 0, nums.length - 1, target);
    }


    private static int binarySearchInsert(int[] nums, int i, int j, int target) {
        int mid = (i + j) / 2;
        if (i <= j) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return binarySearchInsert(nums, mid + 1, j, target);
            } else {
                return binarySearchInsert(nums, 0, mid - 1, target);
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 5, 6, 7, 8, 9, 10};
        System.out.println("3 == " + searchInsert(input, 6));
        System.out.println("1 == " + searchInsert(input, 2));
    }
}
