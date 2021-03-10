package graph;/**
 * @author Weiyan Xiang on 2021/3/10
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindEventualSafeStates {
    /**
     * 802. Find Eventual Safe States
     * <p>
     * https://leetcode.com/problems/find-eventual-safe-states/
     * <p>
     * my ac ans: dfs topological sort, very similar to CourseScheduleTwo
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // safe :1, visiting: 0
        Map<Integer, Integer> map = new HashMap<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            dfsHasCycle(graph, i, map);
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (map.containsKey(j) && map.get(j) == 1) ans.add(j);
        }
        return ans;
    }

    private boolean dfsHasCycle(int[][] graph, int cur, Map<Integer, Integer> map) {
        if (map.containsKey(cur)) {
            if (map.get(cur) == 0) return true;
            if (map.get(cur) == 1) return false;
        }
        map.put(cur, 0);
        for (int i = 0; i < graph[cur].length; i++) {
            if (dfsHasCycle(graph, graph[cur][i], map)) {
                return true;
            }
        }
        map.put(cur, 1);
        return false;
    }
}
