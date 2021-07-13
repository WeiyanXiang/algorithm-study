package graph;/**
 * @author Weiyan Xiang on 2021/7/13
 */

import java.util.*;

public class MinTimeToCollectAllApples {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    /**
     * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
     * <p>
     * 1443. Minimum Time to Collect All Apples in a Tree
     * <p>
     * upvoted ans: Key idea Whenever you are at a node, say p, you will collect all apples in p’s subtree before
     * returning back to the original root. This will avoid traveling the same path multiple times. Say, root is where
     * we start, p is a node in the tree and p has two children - child1, child2 - and both of them have an apple each.
     * root -> p -> child1 -> p -> child2 -> p -> rootis always going to be better than root-> p -> child1 -> p -> root
     * -> p -> child2 -> p -> root.
     * <p>
     * So now it becomes a simple graph traversal problem, particularly DFS where we visit all children of the node
     * first and then go back the other nodes.
     * <p>
     * Algorithm
     * <p>
     * Because you have the list of edges, construct the graph first to have a better representation of the graph. For
     * each node, check if any of its children have apples and find the total cost in terms of time in seconds of
     * collecting those. If there is at least one child with an apple, then we have to collect it. So we will also have
     * to add the cost (time required) of reaching that node. return the total time.
     */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        boolean[] visited = new boolean[n + 1];
        // build graph
        build(edges, graph);
        return dfs(0, hasApple, visited);
    }

    private void build(int[][] edges, Map<Integer, List<Integer>> graph) {
        for (int[] pair : edges) {
            int a = pair[0], b = pair[1];
            graph.putIfAbsent(a, new LinkedList<>());
            graph.putIfAbsent(b, new LinkedList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    private int dfs(int node, List<Boolean> hasApple, boolean[] v) {
        v[node] = true;
        int res = 0;
        for (int ele : graph.getOrDefault(node, new ArrayList<>())) {
            if (v[ele]) continue;
            res += dfs(ele, hasApple, v);
        }
        if ((res > 0 || hasApple.get(node)) && node != 0) res += 2;
        return res;
    }

}
