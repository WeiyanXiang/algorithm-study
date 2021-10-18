package tree;

/**
 * @author Weiyan Xiang on 2021/10/18
 */

public class CousinsInBinaryTree {
    class ReturnNode {
        int val;
        int dep;

        ReturnNode(int val, int dep) {
            this.val = val;
            this.dep = dep;
        }
    }

    /**
     * 993. Cousins in Binary Tree
     * <p>
     * https://leetcode.com/problems/cousins-in-binary-tree/
     * <p>
     * my ac ans: dfs to check parent not same and dep same
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) return false;
        ReturnNode xx = findChildD(root, x, 0);
        ReturnNode yy = findChildD(root, y, 0);
        return xx.dep == yy.dep && xx.val != yy.val;
    }

    private ReturnNode findChildD(TreeNode root, int target, int dep) {
        if (root == null) return new ReturnNode(0, 0);
        if (root.left != null && root.left.val == target) return new ReturnNode(root.val, dep);
        if (root.right != null && root.right.val == target) return new ReturnNode(root.val, dep);
        ReturnNode left = findChildD(root.left, target, dep + 1);
        ReturnNode right = findChildD(root.right, target, dep + 1);
        return left.val == 0 ? right : left;
    }
}
