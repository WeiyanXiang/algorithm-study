package search.backtrack;/**
 * @author Weiyan Xiang on 2021/2/16
 */

import java.util.HashSet;
import java.util.Set;

public class MaxNumberOfUniqueSubstrings {
    /**
     * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
     * <p>
     * mostly my ac answer, typical backtrack
     */
    int max = 0;

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        dfs(s, 0, set, "");
        return max;
    }

    private void dfs(String s, int start, Set<String> ans, String cur) {
        if (start == s.length()) {
            max = Math.max(max, ans.size());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String newS = s.substring(start, i + 1);
            if (ans.contains(newS)) continue;
            ans.add(newS);
            dfs(s, i + 1, ans, newS);
            ans.remove(newS);
        }
    }
}
