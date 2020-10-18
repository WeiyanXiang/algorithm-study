package graph;

import java.util.LinkedList;

/**
 * @author Weiyan Xiang on 2020/6/20
 */
public class BFS {

    boolean[] visitied = new boolean[20];
    LinkedList<Integer> queue = new LinkedList<>();

    /**
     * BFS traversal from a given source s
     */
    public void doBfs(Graph graph, int s, int graphSize) {
        visitied[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int latest = queue.poll();
            System.out.print("[" + latest + "] ");
            addUnvisitedChildrenToQueue(graph.adj[latest]);
        }

    }

    private void addUnvisitedChildrenToQueue(LinkedList<Integer> adj) {
        adj.stream().forEach(e -> {
            if (!visitied[e]) {
                visitied[e] = true;
                queue.add(e);
            }
        });
    }
}
