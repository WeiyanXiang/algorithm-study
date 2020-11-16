package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/15
 */
public class FindAnagrams {

    /**
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/
     * <p>
     * using template
     */
    public List<Integer> findAnagrams(String s, String p) {
        int l = 0, r = 0, count = 0;
        List<Integer> res = new ArrayList<>();
        int[] pChars = new int[26];
        int[] win = new int[26];
        for (char pc : p.toCharArray()) pChars[pc - 'a']++;
        while (r < s.length()) {
            // right
            win[s.charAt(r) - 'a']++;
            count++;

            // left
            while (count > p.length()) {
                win[s.charAt(l) - 'a']--;
                count--;
                l++;
            }
            // update result
            if (Arrays.equals(win, pChars)) res.add(l);

            r++;
        }
        return res;
    }
}
