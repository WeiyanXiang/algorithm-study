package graph;

/**
 * @author Weiyan Xiang on 2021/3/21
 */

public class IsGraphBipartite {
    /**
     * 785. Is Graph Bipartite?
     * <p>
     * https://leetcode.com/problems/is-graph-bipartite/
     * <p>
     * very similar question in: 886. Possible Bipartition
     * <p>
     * https://leetcode.com/problems/possible-bipartition/
     * <p>
     * template ques: For each node,
     * <p>
     * - If it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes
     * (DFS).
     * <p>
     * - If it has been colored, check if the current color is the same as the color that is going to be used to color
     * it.
     */
    public boolean isBipartite(int[][] graph) {
        // template question
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            // if not colored and it is invalid after coloring
            if (colors[i] == 0 && !dfsValid(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfsValid(int[][] graph, int[] colors, int color, int index) {
        if (colors[index] != 0) return colors[index] == color;
        colors[index] = color;
        for (int next : graph[index]) {
            if (!dfsValid(graph, colors, -color, next)) return false;
        }
        return true;
    }
}
