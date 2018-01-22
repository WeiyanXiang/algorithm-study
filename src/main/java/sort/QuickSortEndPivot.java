/**
 * 
 */
package sort;

/**
 * @author weiyan.xiang
 * @date 20 Jan 2018
 */
public class QuickSortEndPivot {
    public static void main(String[] args) {
        int[] testObj = { 1, 4, 6, 2, 7, 12, 3, 8, 5 };
        new QuickSortEndPivot().quickSort(testObj, 0, testObj.length - 1);
        for (int element : testObj) {
            System.out.println(element);
        }
        System.out.println(21438474 > Integer.MAX_VALUE / 10);

    }

    private void quickSort(int[] input, int start, int end) {
        if (start < end) {
            int part = partition(input, start, end);
            quickSort(input, start, part - 1);
            quickSort(input, part + 1, end);
        }
    }

    private int partition(int[] input, int start, int end) {
        int answer = start - 1;
        int pivot = input[end];
        // reason why not i <= end is because end index is already picked as
        // pivot and being swapped end of loop
        for (int i = start; i < end; i++) {
            if (input[i] <= pivot) {
                answer++;
                swap(input, i, answer);
            }
        }
        swap(input, answer + 1, end);
        return answer + 1;
    }

    private void swap(int[] input, int source, int arrival) {
        int temp = input[source];
        input[source] = input[arrival];
        input[arrival] = temp;
    }

}
