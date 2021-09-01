package tree;

/**
 * @author Weiyan Xiang on 2020/6/9
 */
public class ValidateBST {

    /**
     * 98. Validate Binary Search Tree
     * <p>
     * https://leetcode.com/problems/validate-binary-search-tree/
     * <p>
     * upvoted ans
     */
    public boolean isValidBST(TreeNode root) {
        return doCheck(root, null, null);
    }

    // use TreeNode min and max instead of int to overcome the test case of max integer
    private boolean doCheck(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return doCheck(root.left, min, root) && doCheck(root.right, root, max);
    }


}
