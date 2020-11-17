package twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Weiyan Xiang on 2020/11/17
 */
public class ReverseVowelsOfString {

    /**
     * https://leetcode.com/problems/reverse-vowels-of-a-string/
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0, j = s.length() - 1;
        char[] ss = s.toCharArray();
        Character temp;
        while (i < j && i < ss.length && j >= 0) {
            if (!set.contains(ss[i])) {
                i++;
            } else if (!set.contains(ss[j])) {
                j--;
            } else {
                temp = ss[i];
                ss[i] = ss[j];
                ss[j] = temp;
                i++;
                j--;
            }
        }
        return new String(ss);
    }
}
