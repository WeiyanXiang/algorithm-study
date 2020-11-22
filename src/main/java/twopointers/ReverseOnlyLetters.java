package twopointers;

/**
 * @author Weiyan Xiang on 2020/11/22
 */
public class ReverseOnlyLetters {

    /**
     * 917. Reverse Only Letters
     * <p>
     * https://leetcode.com/problems/reverse-only-letters/
     */
    public String reverseOnlyLetters(String S) {
        char[] s = S.toCharArray();
        int l = 0, r = s.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(s[l])) l++;
            while (l < r && !Character.isLetter(s[r])) r--;
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
        return new String(s);
    }
}
