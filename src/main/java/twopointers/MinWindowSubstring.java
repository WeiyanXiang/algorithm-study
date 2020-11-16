package twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Weiyan Xiang on 2020/11/14
 */
public class MinWindowSubstring {
    /**
     * https://leetcode.com/problems/minimum-window-substring/
     */
    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        Map<Character, Integer> tChars = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();
        String res = "";
        for (char tc : t.toCharArray()) {
            if (tChars.containsKey(tc)) tChars.put(tc, tChars.get(tc) + 1);
            else tChars.put(tc, 1);
        }
        while (r < s.length()) {
            // right
            add(win, s.charAt(r));
            r++;
            // left
            while (containsAll(win, tChars)) {
                res = res == "" || r - l < res.length() ? s.substring(l, r) : res;
                reduce(win, s.charAt(l));
                l++;
            }
        }
        return res;
    }

    private boolean containsAll(Map<Character, Integer> win, Map<Character, Integer> tChars) {
        for (Map.Entry<Character, Integer> entry : tChars.entrySet()) {
            if (!(win.containsKey(entry.getKey()) && win.get(entry.getKey()) >= entry.getValue()))
                return false;
        }
        return true;
    }

    private void add(Map<Character, Integer> map, char tc) {
        if (map.containsKey(tc)) map.put(tc, map.get(tc) + 1);
        else map.put(tc, 1);
    }

    private void reduce(Map<Character, Integer> map, char tc) {
        map.put(tc, map.get(tc) - 1);
    }

}
