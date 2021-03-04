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
     * original dfs ans will TLE, adding DP array below to avoid revisiting node
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
