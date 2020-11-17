package twopointers;

/**
 * @author Weiyan Xiang on 2020/11/17
 */
public class SumOfSquareNumbers {
    /**
     * https://leetcode.com/problems/sum-of-square-numbers/
     */
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int r = (int) Math.sqrt(c);
        int l = 0;
        while (l <= r) {
            int sum = l * l + r * r;
            if (sum == c) return true;
            if (sum < c) l++;
            else r--;
        }
        return false;
    }
}
