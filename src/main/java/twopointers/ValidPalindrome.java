package twopointers;

/**
 * @author Weiyan Xiang on 2020/11/22
 */
public class ValidPalindrome {
    /**
     * 125. Valid Palindrome
     * <p>
     * https://leetcode.com/problems/valid-palindrome/
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
}
