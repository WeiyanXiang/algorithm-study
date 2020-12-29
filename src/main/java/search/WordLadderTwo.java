package search;/**
 * @author Weiyan Xiang on 2020/12/29
 */

import java.util.*;

public class WordLadderTwo {
    /**
     * 126. Word Ladder II
     * <p>
     * https://leetcode.com/problems/word-ladder-ii/
     */
    public List<List<String>> findLadders(String bw, String ew, List<String> wl) {
        List<List<String>> ans = new ArrayList<>();
        // build dict
        Set<String> dict = new HashSet<>(wl);
        if (!wl.contains(ew)) return ans;
        // bfs
        // key: word, value: shortest path length which reaches this word
        Map<String, Integer> steps = new HashMap<>();
        steps.put(bw, 1);
        // key: word, value: list of words that are parents of current word
        Map<String, List<String>> parents = new HashMap<>();
        for (String str : dict) parents.put(str, new ArrayList<>());

        int l = bw.length();
        int step = 0;
        boolean found = false;

        LinkedList<String> queue = new LinkedList<>();
        queue.add(bw);

        while (!queue.isEmpty() && !found) {
                step++;
            int qs = queue.size();
            // for each level
            for (int ss = 0; ss < qs; ss++) {
                String p = queue.poll();
                char[] chs = p.toCharArray();
                for (int i = 0; i < l; i++) {
                    char cc = chs[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        // if j is same as current letter, skip
                        if (j == cc) continue;
                        chs[i] = j;
                        String w = new String(chs);
                        if (w.equals(ew)) {
                            parents.get(w).add(p);
                            found = true;
                        } else {
                            // Not a new word, but another transform
                            // with the same number of steps
                            if (steps.containsKey(w) && step < steps.get(w)) {
                                parents.get(w).add(p);
                            }
                        }
                        if (!dict.contains(w)) continue;
                        dict.remove(w);
                        queue.add(w);
                        steps.put(w, step + 1);
                        parents.get(w).add(p);
                    }
                    chs[i] = cc;
                }
            }
            if (found) {
                List<String> curr = new ArrayList<>();
                curr.add(ew);
                dfsGetPaths(ew, bw, parents, curr, ans);
            }
        }
        return ans;
    }

    private void dfsGetPaths(String word, String bw, Map<String, List<String>> parents,
                             List<String> curr, List<List<String>> ans) {
        if (word == bw) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (String p : parents.get(word)) {
            curr.add(p);
            dfsGetPaths(p, bw, parents, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
