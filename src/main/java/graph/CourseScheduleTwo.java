package graph;/**
 * @author Weiyan Xiang on 2021/3/8
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseScheduleTwo {

    /**
     * 210. Course Schedule II
     * <p>
     * https://leetcode.com/problems/course-schedule-ii/
     *
     * huahua ans, topological sort
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        // build graph
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[numCourses];
        // dfs graph to detect cycles
        for (int z = 0; z < numCourses; z++) {
            if (dfsHasCycle(z, graph, visited, ans)) {
                ans.clear();
                return new int[0];
            }

        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfsHasCycle(int cur, List<Integer>[] graph, int[] visited, List<Integer> ans) {
        if (visited[cur] == 1) return true;
        if (visited[cur] == 2) return false;
        // mark visiting
        visited[cur] = 1;
        for (int next : graph[cur]) {
            if (dfsHasCycle(next, graph, visited, ans)) return true;
        }
        // mark visited and add to path
        visited[cur] = 2;
        ans.add(cur);
        return false;
    }

}
