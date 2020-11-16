package slidingwindow;

import java.util.Arrays;

/**
 * @author Weiyan Xiang on 2020/11/16
 */
public class PermutationInString {
    /**
     * https://leetcode.com/problems/permutation-in-string/
     * <p>
     * using template
     */
    public boolean checkInclusion(String s1, String s2) {
        int l = 0, r = 0;
        int[] s1cs = new int[26];
        int[] win = new int[26];
        int count = 0;
        for (char s1c : s1.toCharArray()) s1cs[s1c - 'a']++;
        while (r < s2.length()) {
            win[s2.charAt(r) - 'a']++;
            count++;
            r++;
            while (count > s1.length()) {
                win[s2.charAt(l) - 'a']--;
                count--;
                l++;
            }
            if (Arrays.equals(win, s1cs)) return true;
        }
        return false;
    }

}
