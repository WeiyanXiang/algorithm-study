package graph;/**
 * @author Weiyan Xiang on 2021/4/5
 */

import java.util.*;

public class BusRoutes {
    /**
     * 815. Bus Routes
     * <p>
     * https://leetcode.com/problems/bus-routes/
     * <p>
     * huahua ans, build map based on key is stop and value is the list of buses and then BFS
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // build a map: <stop, list of buses>
        // bfs to find the path using least bus
        Map<Integer, List<Integer>> stopMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (stopMap.containsKey(stop)) stopMap.get(stop).add(i);
                else stopMap.put(stop, new ArrayList(Arrays.asList(i)));
            }
        }
        // BFS
        // visited buses
        int[] visited = new int[500];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.add(source);
        if (source == target) return 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            count++;
            for (int i = 0; i < len; i++) {
                int curStop = queue.poll();
                // explore all buses
                for (int bus : stopMap.get(curStop)) {
                    if (visited[bus] != 0) continue;
                    visited[bus] = 1;
                    // try all bus's steps since they are connected components
                    for (int s : routes[bus]) {
                        if (s == target) return count;
                        queue.add(s);
                    }
                }
            }
        }
        return -1;

    }
}
