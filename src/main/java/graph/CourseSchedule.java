package graph;/**
 * @author Weiyan Xiang on 2021/3/4
 */

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    /**
     * 207. Course Schedule
     * <p>
     * https://leetcode.com/problems/course-schedule/
     * <p>
     * huahua ans, topological sort: marking visiting and visited to detected cycle
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build a graph with connected components
        // return false if there is cycle
        List<Integer>[] g = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) g[i] = new ArrayList<>();
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfsHasCycle(g, i, visited)) return false;
        }
        return true;
    }

    private boolean dfsHasCycle(List<Integer>[] g, int cur, int[] visited) {
        if (visited[cur] == 1) return true;
        if (visited[cur] == 2) return false;
        // visiting
        visited[cur] = 1;
        for (int next : g[cur]) {
            if (dfsHasCycle(g, next, visited)) {
                return true;
            }
        }
        visited[cur] = 2;
        return false;
    }

    /**
     * adding DP array below to avoid revisiting node
     */
    public boolean canFinishDp(int numCourses, int[][] prerequisites) {
        // build a graph with connected components
        // return false if there is cycle
        List<Integer>[] g = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) g[i] = new ArrayList<>();
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfsIsValid(g, i, visited, dp)) return false;
        }
        return true;
    }

    private boolean dfsIsValid(List<Integer>[] g, int cur, boolean[] visited, boolean[] dp) {
        if (visited[cur]) return dp[cur];
        visited[cur] = true;
        for (int next : g[cur]) {
            if (!dfsIsValid(g, next, visited, dp)) {
                dp[cur] = false;
                return false;
            }
        }
        dp[cur] = true;
        return true;
    }
}
