package dp;

/**
 * @author Weiyan Xiang on 2021/2/3
 */

public class CountNumbersWithUniqueDigits {

    /**
     * 357. Count Numbers with Unique Digits
     * <p>
     * https://leetcode.com/problems/count-numbers-with-unique-digits/
     * <p>
     * upvoted DP answer
     */
    // f(1) = 10
    // f(2) = 9 * 9
    // f(3) = 9 * 9 * 8 = f(2) * 8
    // f(4) = 9 * 9 * 7 = f(3) * 7
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int base = 9, func = 10, res = 10;
        for (int i = 1; i < n; i++) {
            int temp = doFunc(func, base--);
            res += temp;
            func = temp;
        }
        return res;
    }

    private int doFunc(int previousFuncRes, int base) {
        return (previousFuncRes == 10 ? 9 : previousFuncRes) * base;
    }
}
