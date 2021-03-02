package graph;/**
 * @author Weiyan Xiang on 2021/3/2
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmallestStringWithSwaps {
    /**
     * 1202. Smallest String With Swaps
     * <p>
     * https://leetcode.com/problems/smallest-string-with-swaps/
     */
    private String ans;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        ans = s;
        // permutation thinking since can swap based on same pair any number of times
        Set<String> used = new HashSet<>();
        dfs(s, pairs, s, used);
        return ans;
    }

    // swap method
    // smallest string
    private void dfs(String s, List<List<Integer>> pairs, String cur, Set<String> used) {
        if (cur.compareTo(s) < 0) {
            ans = cur;
            return;
        }
        for (int i = 0; i < pairs.size(); i++) {
            if (used.contains(cur)) continue;

            cur = swap(cur, pairs.get(i));
            used.add(cur);

            dfs(s, pairs, cur, used);

            used.remove(cur);
            cur = swap(cur, pairs.get(i));
        }
    }

    private String swap(String cur, List<Integer> pair) {
        char[] chs = cur.toCharArray();
        char temp = chs[pair.get(0)];
        chs[pair.get(0)] = chs[pair.get(1)];
        chs[pair.get(1)] = temp;
        return new String(chs);
    }
}
