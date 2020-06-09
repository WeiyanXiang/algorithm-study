package tree;

/**
 * @author Weiyan Xiang on 2020/6/9
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return doCheck(root, null, null);
    }

    private static boolean doCheck(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        return doCheck(root.left, min, root.val) && doCheck(root.right, root.val, max);
    }
}
