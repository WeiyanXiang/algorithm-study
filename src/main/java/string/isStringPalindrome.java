package string;

import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.toLowerCase;

/**
 * @author Weiyan Xiang on 2020/5/21
 */
public class isStringPalindrome {
    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * <p>
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     * <p>
     * Example 1:
     * <p>
     * Input: "A man, a plan, a canal: Panama" Output: true Example 2:
     * <p>
     * Input: "race a car" Output: false
     */

    public boolean isPalindrome(String input) {
        char[] s = input.toCharArray();
        int i = 0, j = s.length - 1;
        while (i < j) {
            if (!isLetterOrDigit(s[i])) i++;
            else if (!isLetterOrDigit(s[j])) j--;
            else if (toLowerCase(s[i++]) != toLowerCase(s[j--])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        isStringPalindrome maybePalindrome = new isStringPalindrome();
        System.out.println(maybePalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(maybePalindrome.isPalindrome("race a car"));
    }

}
