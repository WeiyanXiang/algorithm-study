package search;/**
 * @author Weiyan Xiang on 2021/1/17
 */

import java.util.*;

public class WordBreak {
    private Set<String> dict = new HashSet<>();

    /**
     * 139. Word Break
     * <p>
     * https://leetcode.com/problems/word-break/
     * <p>
     * recursion ans: not AC, TLE
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        return check(s);
    }

    private boolean check(String s) {
        if (s.isEmpty()) return true;
        for (int i = 1; i <= s.length(); i++) {
            String p1 = s.substring(0, i);
            String p2 = s.substring(i);
            if (dict.contains(p1) && check(p2)) return true;
        }
        return false;
    }

    private Map<String, Boolean> map = new HashMap<>();

    /**
     * my ac ans with recurison with mem, not fast though
     */
    public boolean wordBreakRecurWithMem(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        return checkWithMem(s);
    }

    private boolean checkWithMem(String s) {
        if (map.containsKey(s)) return map.get(s);
        int len = s.length();
        if (len == 0) {
            map.put(s, true);
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            String p1 = s.substring(0, i);
            String p2 = s.substring(i);
            if (dict.contains(p1) && map.getOrDefault(p2, checkWithMem(p2))) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
