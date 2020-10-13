/**
 *
 */
package sort;

/**
 * @author weiyan.xiang
 * @date 24 Jan 2018
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch mbs = new BinarySearch();
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        System.out.println("Key 14's position: " + mbs.binarySearch(arr, 14));
        System.out.println("Key 14's position (recur): " + mbs.binarySearchRecur(arr, 14, 0, 7));
        int[] arr1 = {6, 34, 78, 123, 432, 900};
        System.out.println("Key 432's position: " + mbs.binarySearch(arr1, 1));
        System.out.println("Key 432's position (recur): " + mbs.binarySearchRecur(arr1, 1, 0, 7));
    }

    /**
     * binary search on sorted array
     * <p>
     * recursive
     *
     * @param arr
     * @param input
     * @param j
     * @param k
     * @return
     */
    private int binarySearchRecur(int[] arr, int input, int j, int k) {
        if (j < k) {
            int mid = (k + j) / 2;
            if (arr[mid] == input) {
                return mid;
            } else if (input > arr[mid]) {
                return binarySearchRecur(arr, input, mid + 1, k);
            } else {
                return binarySearchRecur(arr, input, j, mid);
            }
        }
        return -1;
    }

    /**
     * iterative
     *
     * @param arr
     * @param key
     * @return
     */
    private int binarySearch(int[] arr, int key) {
        int a = 0, b = arr.length - 1;
        while (a <= b) {
            int mid = (a + b) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                a = mid + 1;
            } else {
                b = mid - 1;
            }
        }
        return -1;
    }

}
