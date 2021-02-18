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
        visited[s] = true;
        System.out.print("[" + s + "] ");
        for (int e : g.adj[s]) {
            if (!visited[e]) {
                doDfs(g, e);
            }
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
            for (int e : g.adj[top]) {
                if (!myVisited[e]) {
                    stack.push(e);
                    myVisited[e] = true;
                }
            }
        }

    }

    /**
     * my own answer for adj matrix. It should be correct.
     * <p>
     * it is also possible to use recursive, same idea as recusive adj list approaches.
     *
     * @param grid
     */
    public void doDfsGraphMatrix(char[][] grid) {
        boolean[] myVisited = new boolean[8];
        // row number represents node, so row number will be pushed to stack
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        myVisited[0] = true;
        // should be same idea, when adj list, loop the row
        while (!stack.isEmpty()) {
            int r = stack.pop();
            System.out.print("[" + r + "] ");
            for (int c = 0; c < grid[r].length; c++) {
                // when there is a path
                if (grid[r][c] == '1' && !visited[c]) {
                    stack.push(c);
                    visited[c] = true;
                }
            }
        }


    }

}
