package tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/11/25
 */
public class BinaryTreePreorderTraversal {

    /**
     * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
     * <p>
     * 589. N-ary Tree Preorder Traversal
     * <p>
     * my ac answer:
     */
    // dfs
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node cur = root;
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            ans.add(top.val);
            for (int i = top.children.size() - 1; i >= 0; i--) {
                stack.push(top.children.get(i));
            }
        }
        return ans;
    }

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderRecursive(Node root) {
        if (root == null) return ans;
        ans.add(root.val);
        for (Node n : root.children) {
            preorderRecursive(n);
        }
        return ans;
    }
}
