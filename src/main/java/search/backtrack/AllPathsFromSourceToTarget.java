package search.backtrack;/**
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
}
