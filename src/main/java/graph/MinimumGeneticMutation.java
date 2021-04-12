package graph;/**
 * @author Weiyan Xiang on 2021/4/4
 */

import java.util.*;

public class MinimumGeneticMutation {
    /**
     * 433. Minimum Genetic Mutation
     * <p>
     * https://leetcode.com/problems/minimum-genetic-mutation/
     * <p>
     * my own ac answer: BFS
     */
    public int minMutation(String start, String end, String[] bank) {
        // bfs find the shortest path
        Queue<String> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        queue.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String cur = queue.poll();
                if (visited.containsKey(cur) && visited.get(cur)) continue;
                visited.put(cur, true);
                if (cur.equals(end)) {
                    return count;
                }
                List<String> nextAvailableGene = getNextAvailableGene(cur, bank);
                queue.addAll(nextAvailableGene);
            }
            count++;
        }
        return -1;
    }

    private List<String> getNextAvailableGene(String cur, String[] bank) {
        List<String> ans = new ArrayList<>();
        int difCount = 0;
        for (String b : bank) {
            for (int i = 0; i < 8; i++) {
                if (cur.charAt(i) != b.charAt(i)) difCount++;
            }
            if (difCount == 1) ans.add(b);
            difCount = 0;
        }
        return ans;
    }
}
