package tree.traverse;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * @author Weiyan Xiang on 2020/11/29
 */
public class DeepestLeavesSum {

    int mySum = 0;

    /**
     * 1302. Deepest Leaves Sum
     * <p>
     * https://leetcode.com/problems/deepest-leaves-sum/
     */
    public int deepestLeavesSumMyAnswer(TreeNode root) {
        TreeNode cur = root;
        int depth = findDepth(cur);
        dfs(cur, depth, 1, 1);
        return mySum;
    }

    private void dfs(TreeNode root, int d, int curDLeft, int curDRight) {
        if (root == null) return;
        else {
            if (curDLeft == d || curDRight == d) mySum += root.val;
            dfs(root.left, d, ++curDLeft, curDRight);
            dfs(root.right, d, curDLeft, ++curDRight);
        }
    }

    private int findDepth(TreeNode node) {
        if (node == null) return 0;
        else return 1 + Math.max(findDepth(node.left), findDepth(node.right));
    }

    int sum = 0;
    int maxD = 0;


    /**
     * most upvoted answer: dfs and depth in one go
     */
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) return;
        if (d > maxD) {
            maxD = d;
            sum = 0;
        }
        if (d == maxD) {
            sum += root.val;
        }
        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }

    /**
     * most upvoted answer in BFS / level order traverse
     */
    public int deepestLeavesSumBfs(TreeNode root) {
        int sum = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            sum = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode top = queue.poll();
                sum += top.val;
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
            }
        }
        return sum;
    }
}
