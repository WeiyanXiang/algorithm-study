package math;

/**
 * @author Weiyan Xiang on 2020/7/5
 */
public class Base7 {

    /**
     * https://leetcode.com/problems/base-7/ Given an integer, return its base 7 string representation.
     * <p>
     * Example 1: Input: 100 Output: "202"
     * <p>
     * Example 2: Input: -7 Output: "-10"
     * <p>
     * Note: The input will be in range of [-1e7, 1e7].
     *
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder str = new StringBuilder();
        boolean isNeg = false;
        if (num < 0) {
            num = -num;
            isNeg = true;
        }
        while (num > 0) {
            str.append(num % 7);
            num = num / 7;
        }
        if (isNeg) str.append("-");
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Base7().convertToBase7(-7));
    }
}
