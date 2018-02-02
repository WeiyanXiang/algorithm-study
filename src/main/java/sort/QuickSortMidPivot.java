/**
 * 
 */
package sort;

/**
 * @author weiyan.xiang
 * @date 2 Feb 2018
 */
public class QuickSortMidPivot {
    public void sort(int[] input, int low, int high) {
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
            sort(input, low, j);
        }
        if (high > i) {
            sort(input, i, high);
        }
    }

    public static void main(String[] args) {
        int[] testObj = { 1, 4, 6, 2, 7, 12, 3, 8, 5 };
        new QuickSortMidPivot().sort(testObj, 0, testObj.length - 1);
        for (int element : testObj) {
            System.out.println(element);
        }
    }

}
