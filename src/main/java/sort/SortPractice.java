/**
 * 
 */
package sort;

/**
 * @author weiyan.xiang
 * @date 5 Feb 2018
 */
public class SortPractice {
    private static int[] testObj = { 1, 4, 6, 2, 7, 12, 3, 8, 5 };
    private static int[] testObjAnother = { 1, 4, 6, 2, 7, 12, 3, 8, 5 };
    private int[] helper = new int[10];

    private void mergeSort(int[] input, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(input, l, mid);
            mergeSort(input, mid + 1, r);
            doMerge(input, l, mid, r);
        }
    }

    private void doMerge(int[] input, int l, int mid, int r) {
        for (int i = 0; i < input.length; i++) {
            helper[i] = input[i];
        }
        int a = l, b = mid + 1, c = l;

        while (a <= mid && b <= r) {
            if (helper[a] < helper[b]) {
                input[c++] = helper[a++];
            } else {
                input[c++] = helper[b++];
            }
        }
        while (a <= mid) {
            input[c++] = helper[a++];
        }
    }

    public void quickSort(int[] input, int low, int high) {
        if (input == null || input.length == 0 || low >= high)
            return;
        int mid = (low + high) / 2;
        int pivot = input[mid];

        int i = low, j = high;
        while (i <= j) {
            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(input, low, j);
        }
        if (i < high) {
            quickSort(input, i, high);
        }

    }

    public static void main(String[] args) {
        SortPractice instance = new SortPractice();
        instance.mergeSort(testObj, 0, testObj.length - 1);
        for (int element : testObj) {
            System.out.println(element);
        }
        System.out.println();
        instance.quickSort(testObjAnother, 0, testObjAnother.length - 1);
        for (int element : testObjAnother) {
            System.out.println(element);
        }
    }

}
