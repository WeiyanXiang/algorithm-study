package math;

/**
 * @author Weiyan Xiang on 2020/5/21
 */

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array
 * contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the integer 123. Example 2:
 * <p>
 * Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents the integer 4321.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {

        }
        return null;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {4, 3, 2, 1};
        for (int e : plusOne.plusOne(digits)) {
            System.out.print(e + " ");
        }
    }


}
