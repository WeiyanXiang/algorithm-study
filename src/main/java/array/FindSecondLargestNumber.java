package array;

/**
 * @author Weiyan Xiang on 2020/3/20
 */
public class FindSecondLargestNumber {

    private static int solution(int[] array) {
        if (array == null || array.length == 0) throw new RuntimeException("array cannot be null/empty");

        int first = array[0], second = array[0], temp = first;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > first) {
                temp = first;
                first = array[i];
                second = temp;
            } else if (array[i] > second && array[i] != first) {
                second = array[i];
            }
        }
        return second;
    }


    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 6, 7, 7};
        System.out.println(solution(input));
    }
}
