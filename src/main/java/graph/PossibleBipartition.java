package graph;/**
 * @author Weiyan Xiang on 2021/3/21
 */

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition {
    /**
     * 886. Possible Bipartition
     * <p>
     * https://leetcode.com/problems/possible-bipartition/
     * <p>
     * build adj list graph and then same algo to IsGraphBipartite
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            int a = d[0] - 1;
            int b = d[1] - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
            // colored, skip
            if (colors[i] != 0) continue;
            if (!dfsValidColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfsValidColor(List<Integer>[] g, int[] colors, int color, int index) {
        if (colors[index] != 0) return colors[index] == color;
        colors[index] = color;
        for (int next : g[index]) {
            if (!dfsValidColor(g, colors, -color, next)) return false;
        }
        return true;
    }
}
