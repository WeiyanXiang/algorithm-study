package tree.traverse;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/11/24
 */
public class BinaryTreeInorderTraversal {
    /**
     * 94. Binary Tree Inorder Traversal
     * <p>
     * https://leetcode.com/problems/binary-tree-inorder-traversal/
     * <p>
     * my ac answer: recursive.
     * <p>
     * same template can apply to preorder and postorder:
     * <p>
     * 144. Binary Tree Preorder Traversal
     * <p>
     * https://leetcode.com/problems/binary-tree-preorder-traversal/
     * <p>
     * 145. Binary Tree Postorder Traversal
     * <p>
     * https://leetcode.com/problems/binary-tree-postorder-traversal/
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(ans, root);
        return ans;
    }

    private void traverse(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        else {
            traverse(ans, root.left);
            ans.add(root.val);
            traverse(ans, root.right);
        }
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        // root left right
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                ans.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();
                cur = top.right;
            }
        }
        return ans;
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        // left root right
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();
                ans.add(top.val);
                cur = top.right;
            }
        }
        return ans;
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        LinkedList<Integer> ans = new LinkedList<>();
        // right left root
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                ans.addFirst(cur.val); // reverse of preorder
                stack.push(cur);
                cur = cur.right;
            } else {
                TreeNode top = stack.pop();
                cur = top.left;
            }
        }
        return ans;
    }

}
