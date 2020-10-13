package sort;

import static utils.PrintUtils.printArray;

/**
 * @author Weiyan Xiang on 2020/5/24
 * <p>
 * Bubble, Selection and Insertion sort
 */
public class BasicSort {
    private static int[] inputs1 = {1, 4, 6, 2, 7, 12, 3, 8, 5};
    private static int[] inputs2 = {1, 43, 6, 3, 9, 12, 13, 28, 5};
    private static int[] inputs3 = {11, 421, 6, 5, 11, 22, 3, 58, 5};

    /**
     * Move higher valued elements generally towards the right and lower value elements generally towards the left
     *
     * @param inputs
     */
    private static void bubbleSort(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            for (int j = i + 1; j < inputs.length; j++) {
                if (inputs[i] > inputs[j]) {
                    int temp = inputs[i];
                    inputs[i] = inputs[j];
                    inputs[j] = temp;
                }
            }
        }
    }

    /**
     * Find the smallest unsorted element and add it to the end of the sorted list.
     *
     * @param inputs
     */
    private static void selectionSort(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            // current smallest index
            int s = i;
            for (int j = i + 1; j < inputs.length; j++) {
                if (inputs[s] > inputs[j]) {
                    s = j;
                }
            }
            int temp = inputs[i];
            inputs[i] = inputs[s];
            inputs[s] = temp;
        }

    }

    /**
     * Build sorted array in place, shift elements out of the way if necessary to make room as you go.
     *
     * @param inputs
     */
    private static void insertionSort(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            int ele = inputs[i];
            int j;
            for (j = i; j > 0 && inputs[j - 1] > ele; j--) {
                inputs[j] = inputs[j - 1];
            }
            inputs[j] = ele;
        }
    }

    public static void main(String[] args) {
        printArray(inputs1);
        bubbleSort(inputs1);
        printArray(inputs1);
        System.out.println();


        printArray(inputs2);
        selectionSort(inputs2);
        printArray(inputs2);
        System.out.println();


        printArray(inputs3);
        insertionSort(inputs3);
        printArray(inputs3);
    }


}
