package graph;

import java.util.Stack;

/**
 * @author Weiyan Xiang on 2021/2/18
 */

public class NumberOfProvinces {

    /**
     * 547. Number of Provinces
     * <p>
     * https://leetcode.com/problems/number-of-provinces/
     * <p>
     * upvote ans: loop through adj matrix and dfs each path, with boolean array to track whether been visited
     */
    public int findCircleNum(int[][] grid) {
        int n = grid.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // dfs to search current path until finished. mark visited. they should be one province
                dfs(grid, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] grid, boolean[] visited, int index) {
        for (int i = 0; i < grid[index].length; i++) {
            if (!visited[i] && grid[index][i] == 1) {
                visited[i] = true;
                dfs(grid, visited, i);
            }
        }
    }

    /**
     * my own dfs ans with iterative idea
     */
    public int findCircleNumIterativeDfs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsIterative(grid, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfsIterative(int[][] grid, boolean[] visited, int index) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        visited[index] = true;
        while (!stack.isEmpty()) {
            int r = stack.pop();
            for (int j = 0; j < grid[r].length; j++) {
                if (!visited[j] && grid[r][j] == 1) {
                    visited[j] = true;
                    stack.push(j);
                }
            }
        }
    }

}
