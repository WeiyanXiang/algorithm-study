/**
 *
 */
package twopointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author weiyan.xiang
 * @date 14 Jan 2018
 */
public class LongestSubString {

    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */

    /**
     * my version using template
     */
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, res = 0;
        Map<Character, Integer> win = new HashMap<>();
        while (r < s.length()) {
            char cur = s.charAt(r);
            while (win.containsKey(cur)) {
                char curLeft = s.charAt(l);
                l = Math.max(l + 1, win.get(s.charAt(l)) + 1);
                win.remove(curLeft);
            }
            win.put(cur, r);
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    /**
     * use a set
     */
    private static int countSubStringLength(String s) {
        int count = 0, index = 0, slow = 0;
        Set<Character> cache = new HashSet<>();
        while (index < s.length()) {
            if (!cache.contains(s.charAt(index))) {
                cache.add(s.charAt(index++));
                count = Math.max(count, cache.size());
            } else {
                cache.remove(s.charAt(slow++));
            }
        }
        return count;
    }

    /*
     * use hashmap to validate whether it contains the key. essentially, instead
     * of using a slow pointer to iteratively remove the range until index, we
     * can skip by assigning the index to be Math.max(map.get(s.charAt(index)),
     * slow)
     */
    private static int countSubStringLengthOptimal(String s) {
        int l = 0, r = 0, res = 0;
        Map<Character, Integer> win = new HashMap<>();
        while (r < s.length()) {
            char cur = s.charAt(r);
            if (win.containsKey(cur)) {
                l = Math.max(l, win.get(cur) + 1); // why +1? caz we should have compared and stored max in res.
            }
            win.put(cur, r);
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubStringLength("pwwkew") + " == 3");
        System.out.println(countSubStringLengthOptimal("pwwkew") + " == 3");
        System.out.println(countSubStringLength("bbbbbb") + " == 1");
        System.out.println(countSubStringLengthOptimal("bbbbbb") + " == 1");
        System.out.println(countSubStringLength("abcabcbb") + " == 3");
        System.out.println(countSubStringLengthOptimal("abcabcbb") + " == 3");
    }
}
