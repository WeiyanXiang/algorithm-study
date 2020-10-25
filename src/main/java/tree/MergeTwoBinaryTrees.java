package tree;

/**
 * @author Weiyan Xiang on 2020/10/25
 * <p>
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode ans = new TreeNode();
        ans.val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        ans.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        ans.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return ans;
    }

}
