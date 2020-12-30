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
        Set<String> dict = new HashSet<>(wl);
        List<List<String>> res = new ArrayList<>();
        // key: word, value: list of words that are children/neighbors of current word
        Map<String, List<String>> nodeNeighbors = new HashMap<>();
        // key: word, value: shortest path length which reaches this word
        Map<String, Integer> distance = new HashMap<>();
        List<String> solution = new ArrayList<>();

        dict.add(bw);
        bfs(bw, ew, dict, nodeNeighbors, distance);
        dfs(bw, ew, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    private void bfs(String bw, String ew, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        for (String str : dict) nodeNeighbors.put(str, new ArrayList<>());

        Queue<String> queue = new LinkedList<>();
        queue.offer(bw);
        distance.put(bw, 0);
        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                List<String> neighbors = getNeighbors(cur, dict);
                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (ew.equals(neighbor)) foundEnd = true;
                        else queue.offer(neighbor);
                    }
                }
            }
            if (foundEnd) break;
        }
    }

    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> ans = new ArrayList<>();
        char[] chs = node.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char oldChar = chs[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (chs[i] == ch) continue;
                chs[i] = ch;
                String newWord = new String(chs);
                if (!dict.contains(newWord)) continue;
                ans.add(newWord);
            }
            chs[i] = oldChar;
        }
        return ans;
    }

    private void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors,
                     Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        }
        for (String next : nodeNeighbors.get(cur)) {
            if (distance.get(next) == distance.get(cur) + 1) {
                dfs(next, end, dict, nodeNeighbors, distance, solution, res);
            }
        }
        solution.remove(solution.size() - 1);
    }

}
