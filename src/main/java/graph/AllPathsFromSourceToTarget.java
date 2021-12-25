package graph;/**
 * @author Weiyan Xiang on 2021/1/27
 */

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    /**
     * 797. All Paths From Source to Target
     * <p>
     * https://leetcode.com/problems/all-paths-from-source-to-target/
     * <p>
     * my own ac answer
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // dfs and add to ans list when meeting conditions
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        dfs(graph, ans, cur, 0);
        return ans;
    }

    private void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> cur, int curNode) {
        // if last node in path
        if (curNode == graph.length - 1) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int j = 0; j < graph[curNode].length; j++) {
            if (cur.contains(graph[curNode][j])) continue;
            cur.add(graph[curNode][j]);
            dfs(graph, ans, cur, graph[curNode][j]);
            cur.remove(cur.size() - 1);
        }
    }


    /**
     * my ac ans, use a visited boolean array to track
     */
    List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTargetMyAc(int[][] graph) {
        // dfs with an array of boolean to track visited
        boolean[] visited = new boolean[graph.length];
        traverse(graph, 0, graph.length - 1, new ArrayList<>(), visited);
        return ansList;
    }

    private void traverse(int[][] graph, int start, int end, List<Integer> cur, boolean[] visited) {
        if (visited[start]) return;
        cur.add(start);
        visited[start] = true;
        if (start == end) {
            ansList.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < graph[start].length; i++) {
            traverse(graph, graph[start][i], end, cur, visited);
            visited[graph[start][i]] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
