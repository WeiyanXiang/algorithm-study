package twopointers;

/**
 * @author Weiyan Xiang on 2020/11/17
 */
public class ValidPalindromeTwo {

    /**
     * https://leetcode.com/problems/valid-palindrome-ii/
     */
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
