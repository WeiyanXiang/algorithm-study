package graph;/**
 * @author Weiyan Xiang on 2021/2/3
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    private Map<Integer, Node> aMap = new HashMap<>();

    /**
     * 133. Clone Graph
     * <p>
     * https://leetcode.com/problems/clone-graph/
     * <p>
     * my ac answer
     */
    private Map<Integer, Node> map = new HashMap<>();
    private boolean[] visited = new boolean[101];

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        dfs(node);
        doClone(node);
        return map.get(1);
    }

    // traverse graph and add up neighbors' copied ref
    private void doClone(Node node) {
        if (visited[node.val]) return;
        visited[node.val] = true;
        Node copied = map.get(node.val);
        for (Node nei : node.neighbors) {
            copied.neighbors.add(map.get(nei.val));
            doClone(nei);
        }
    }

    // store copied ref into a map
    private void dfs(Node node) {
        if (map.containsKey(node.val)) return;
        map.put(node.val, new Node(node.val));
        for (Node nei : node.neighbors) {
            dfs(nei);
        }
    }

    /**
     * upvoted answer
     */
    public Node cloneGraphUpvoted(Node node) {
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) return null;
        if (aMap.containsKey(node.val)) return aMap.get(node.val);
        Node newNode = new Node(node.val);
        aMap.put(node.val, newNode);
        for (Node nei : node.neighbors) {
            newNode.neighbors.add(clone(nei));
        }
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
