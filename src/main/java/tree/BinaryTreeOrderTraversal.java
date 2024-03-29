package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/11/24
 */
public class BinaryTreeOrderTraversal {
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
     * <p>
     * A very good explanation from discussion:
     * <p>
     * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
     */
    /**
     * (a) Inorder (Left, Root, Right)
     * <p>
     * (b) Preorder (Root, Left, Right)
     * <p>
     * (c) Postorder (Left, Right, Root)
     */
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    /**
     * only preorder can do below template
     */
    public List<Integer> preorderTraversalIterativeBest(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeNode cur = root;
        stack.push(root);
        // root left right
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return ans;
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
        // left right root
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
