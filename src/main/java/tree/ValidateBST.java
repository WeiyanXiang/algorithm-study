package tree;

/**
 * @author Weiyan Xiang on 2020/6/9
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return doCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean doCheck(TreeNode root, Integer min, Integer max) {
        // stop
        if (root == null) return true;
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        // this & children
        return doCheck(root.left, min, root.val) && doCheck(root.right, root.val, max);
    }


}
