package graph;

import java.util.LinkedList;

/**
 * @author Weiyan Xiang on 2020/6/20
 */
public class BFS {
    /**
     * BFS traversal from a given source s
     * <p>
     * time complexity: O(V+E), where V is vertices and E is edges.
     * <p>
     * space complexity: O(n)
     */
    public void doBfs(Graph graph, int s, int graphSize) {
        boolean[] visited = new boolean[graphSize];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int latest = queue.poll();
            System.out.print("[" + latest + "] ");
            graph.adj[latest].stream().forEach(e -> {
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                }
            });
        }

    }

}
