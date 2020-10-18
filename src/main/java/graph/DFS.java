package graph;

import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/6/20
 * <p>
 * https://www.baeldung.com/java-depth-first-search
 */
public class DFS {

    private boolean[] visited = new boolean[10];

    /**
     * recursive
     */
    public void doDfs(Graph g, int s) {
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.push(s);
        while (!stack.isEmpty()) {
            int top = stack.pop();
            System.out.print("[" + top + "] ");
            g.adj[top].forEach(e -> {
                if (!visited[e]) {
                    doDfs(g, e);
                }
            });
        }

    }

    /**
     * iterative
     * <p>
     * time complexity: O(V+E), where V is vertices and E is edges.
     * <p>
     * space complexity: O(n)
     *
     * @param g
     * @param s
     */
    public void doDfsIterative(Graph g, int s) {
        boolean[] myVisited = new boolean[8];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        myVisited[s] = true;
        while (!stack.isEmpty()) {
            int top = stack.pop();
            System.out.print("[" + top + "] ");
            g.adj[top].forEach(e -> {
                if (!myVisited[e]) {
                    stack.push(e);
                    myVisited[e] = true;
                }
            });
        }

    }

}
