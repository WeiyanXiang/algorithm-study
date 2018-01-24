/**
 * 
 */
package sort;

/**
 * @author weiyan.xiang
 * @date 17 Jan 2018
 */
public class MergeSort {
    private static int[] testObj = { 1, 4, 6, 2, 7, 12, 3, 8, 5 };
    private int[] helper = new int[testObj.length];

    private void sort(int[] input, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(input, start, mid);
            sort(input, mid + 1, end);
            merge(input, start, mid, end);
        }
    }

    private void merge(int[] input, int start, int mid, int end) {
        // copy array to another space
        for (int i = start; i <= end; i++) {
            helper[i] = input[i];
        }
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (helper[i] <= helper[j]) {
                input[k] = helper[i];
                i++;
            } else {
                input[k] = helper[j];
                j++;
            }
            k++;
        }
        // fill up the rest, no needs for j <= end because at end of array it
        // should be already the larger ones there, consider an example of 1 6 7
        // | 4 5 8 or 4 5 8 | 1 6 7
        while (i <= mid) {
            input[k] = helper[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortPrac(testObj, 0, testObj.length - 1);
        for (int element : testObj) {
            System.out.println(element);
        }
    }
}
