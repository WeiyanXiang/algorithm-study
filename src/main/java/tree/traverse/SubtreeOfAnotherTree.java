package tree.traverse;

import tree.TreeNode;

import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/12/5
 */
public class SubtreeOfAnotherTree {
    /**
     * https://leetcode.com/problems/subtree-of-another-tree/
     * <p>
     * 572. Subtree of Another Tree
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * high upvoted alternative answer: using preOrder with Stack
     */
    public boolean isSubtreeStack(TreeNode s, TreeNode t) {
        String sTraverse = genPreOrderString(s);
        String tTraverse = genPreOrderString(t);
        return sTraverse.contains(tTraverse);
    }

    private String genPreOrderString(TreeNode cur) {
        StringBuilder s = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top == null) {
                s.append(",#"); // to avoid t is a subtree in the middle, not until end of all subnodes
            } else {
                s.append("," + top.val);
                stack.push(top.left);
                stack.push(top.right);
            }
        }
        return s.toString();
    }
}
