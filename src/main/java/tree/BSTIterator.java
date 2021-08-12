package tree;/**
 * @author Weiyan Xiang on 2021/8/12
 */

import java.util.Stack;

class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    /**
     * https://leetcode.com/problems/binary-search-tree-iterator/
     * <p>
     * upvoted ans: next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the
     * tree.
     * <p>
     * my initial idea: linkedList and store all inorder traverse, that will be O(1) fetch but O(n) memory
     */
    public BSTIterator(TreeNode root) {
        addAll(root);
    }

    private void addAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode cur = stack.pop();
        addAll(cur.right);
        return cur.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

