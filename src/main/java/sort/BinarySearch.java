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
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16 };
        System.out.println("Key 14's position: " + mbs.binarySearch(arr, 14));
        System.out.println("Key 14's position (recur): " + mbs.binarySearchRecur(arr, 14, 0, 7));
        int[] arr1 = { 6, 34, 78, 123, 432, 900 };
        System.out.println("Key 432's position: " + mbs.binarySearch(arr1, 1));
        System.out.println("Key 432's position (recur): " + mbs.binarySearchRecur(arr1, 1, 0, 7));
    }

    private int binarySearchRecur(int[] arr, int key, int j, int k) {
        if (j <= k) {
            int mid = (k + j) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                return binarySearchRecur(arr, key, mid + 1, k);
            } else {
                return binarySearchRecur(arr, key, j, mid - 1);
            }
        }
        return -1;
    }

    private int binarySearch(int[] arr, int key) {
        int i = arr.length / 2;
        while (i > 0 && i < arr.length) {
            if (key == arr[i]) {
                return i;
            } else if (key > arr[i]) {
                i++;
            } else {
                i--;
            }
        }
        return -1;
    }

}
