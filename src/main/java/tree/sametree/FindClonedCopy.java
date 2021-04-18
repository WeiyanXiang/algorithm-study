package tree.sametree;/**
 * @author Weiyan Xiang on 2021/4/18
 */

import tree.TreeNode;

public class FindClonedCopy {
    TreeNode ans;

    /**
     * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
     *
     * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
     *
     * my ac ans
     *
     * L-R-RETURN pattern
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfsFind(original, cloned, target);
        return ans;
    }

    private boolean dfsFind(TreeNode o, TreeNode c, TreeNode t) {
        if (o == null) return false;
        if (o.val == t.val) ans = c;
        return dfsFind(o.left, c.left, t) || dfsFind(o.right, c.right, t);
    }
}
