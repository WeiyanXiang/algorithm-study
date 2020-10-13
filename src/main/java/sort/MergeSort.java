/**
 *
 */
package sort;

import utils.PrintUtils;

/**
 * @author weiyan.xiang
 * @date 17 Jan 2018
 */
public class MergeSort {
    private static int[] inputs = {1, 4, 6, 2, 7, 12, 3, 8, 5};
    private int[] helper = new int[inputs.length];

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
        int a = start, b = mid + 1, index = start;
        while (a <= mid && b <= end) {
            if (helper[a] < helper[b]) {
                input[index++] = helper[a++];
            } else {
                input[index++] = helper[b++];
            }
        }
        // fill up the rest, no needs for j <= end because at end of array it
        // should be already the larger ones there, consider an example of 1 6 7
        // | 4 5 8 or 4 5 8 | 1 6 7
        while (a <= mid) {
            input[index++] = helper[a++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(inputs, 0, inputs.length - 1);
        PrintUtils.printArray(inputs);
    }
}
