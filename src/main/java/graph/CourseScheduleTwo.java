package graph;/**
 * @author Weiyan Xiang on 2021/3/8
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CourseScheduleTwo {

    /**
     * 210. Course Schedule II
     * <p>
     * https://leetcode.com/problems/course-schedule-ii/
     */
    private List<Integer> validPath = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
            if (!dfsIsValid(g, i, visited, dp, new ArrayList<>())) return convertIntegers(validPath);
        }
        return convertIntegers(validPath);
    }

    public int[] convertIntegers(List<Integer> list) {
        int[] ans = new int[list.size()];
        IntStream.range(0, list.size()).forEach(idx -> ans[idx] = list.get(idx));
        return ans;
    }

    private boolean dfsIsValid(List<Integer>[] g, int cur, boolean[] visited, boolean[] dp, List<Integer> path) {
        if (visited[cur]) return dp[cur];
        visited[cur] = true;
        path.add(cur);
        for (int next : g[cur]) {
            if (!dfsIsValid(g, next, visited, dp, path)) {
                dp[cur] = false;
                return false;
            }
        }
        dp[cur] = true;
        validPath = path;
        return true;
    }


}
