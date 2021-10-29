package array;

/**
 * @author Weiyan Xiang on 2021/10/29
 */

public class PalindromeNumber {
    /**
     * 9. Palindrome Number
     * <p>
     * https://leetcode.com/problems/palindrome-number/
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        char[] xs = (x + "").toCharArray();
        int l = 0, r = xs.length - 1;
        while (l < r) {
            if (xs[l] != xs[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

