package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/25
 */

public class NaryTreeLevelOrderTraversal {
    /**
     * https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/
     * <p>
     * 429. N-ary Tree Level Order Traversal
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<Node> queue = new LinkedList<>();
        Node cur = root;
        queue.add(cur);
        ans.add(Arrays.asList(cur.val));
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node top = queue.poll();
                if (top.children != null) {
                    for (Node n : top.children) {
                        row.add(n.val);
                        queue.add(n);
                    }
                }
            }
            if (!row.isEmpty()) ans.add(row);
        }
        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
