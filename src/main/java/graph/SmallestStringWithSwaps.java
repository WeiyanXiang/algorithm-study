package graph;/**
 * @author Weiyan Xiang on 2021/3/2
 */

import java.util.*;

public class SmallestStringWithSwaps {
    /**
     * 1202. Smallest String With Swaps
     * <p>
     * https://leetcode.com/problems/smallest-string-with-swaps/
     *
     * upvoted dfs ans; union-find ans not included
     */
    Set<Integer> seen = new HashSet<>();
    List<Integer> idx = new ArrayList<>();
    String tmp;
    List<Integer>[] g;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // build graph
        // dfs to find unconnected nodes and connected nodes
        // insert sorted connected nodes into the indexes which having connected nodes
        g = new ArrayList[s.length()];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        for (List<Integer> p : pairs) {
            g[p.get(0)].add(p.get(1));
            g[p.get(1)].add(p.get(0));
        }
        char[] newS = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (seen.contains(i)) continue;
            tmp = "";
            idx.clear();
            dfs(i, s);
            char[] tmpArray = tmp.toCharArray();
            Arrays.sort(tmpArray);
            Collections.sort(idx);
            for (int k = 0; k < idx.size(); k++) {
                newS[idx.get(k)] = tmpArray[k];
            }
        }
        return new String(newS);
    }

    private void dfs(int cur, String s) {
        if (seen.contains(cur)) return;
        seen.add(cur);
        idx.add(cur);
        tmp += s.charAt(cur);
        for (int next : g[cur]) dfs(next, s);
    }
}
