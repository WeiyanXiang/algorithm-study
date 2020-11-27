package tree.traverse;

import java.util.*;

/**
 * @author Weiyan Xiang on 2020/11/25
 */
public class NaryTreePostorderTraversal {

    /**
     * 590. N-ary Tree Postorder Traversal
     * <p>
     * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
     */
    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            ans.add(top.val);
            for (int i = 0; i < top.children.size(); i++) {
                stack.push(top.children.get(i));
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderRecursive(Node root) {
        if (root == null) {
            return ans;
        }
        for (Node n : root.children) {
            postorderRecursive(n);
        }
        ans.add(root.val);
        return ans;
    }
}
