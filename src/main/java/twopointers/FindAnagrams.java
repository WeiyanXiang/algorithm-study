package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/15
 */
public class FindAnagrams {

    /**
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/
     */
    public List<Integer> findAnagrams(String s, String p) {
        int l = 0, r = 0;
        List<Integer> res = new ArrayList<>();
        int[] pChars = new int[26];
        int[] win = new int[26];
        int count = 0;
        for (char c : p.toCharArray()) pChars[c - 'a']++;
        while (r < s.length()) {
            win[s.charAt(r) - 'a']++;
            r++;
            count++;
            if (count > p.length()) {
                win[s.charAt(l) - 'a']--;
                count--;
                l++;
            }
            if (Arrays.equals(pChars, win)) res.add(l);
        }
        return res;

    }
}
