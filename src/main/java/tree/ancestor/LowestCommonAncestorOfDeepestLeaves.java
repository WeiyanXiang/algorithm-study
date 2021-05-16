package tree.ancestor;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2020/12/9
 */
public class LowestCommonAncestorOfDeepestLeaves {
    class ReturnNode {
        TreeNode node;
        int depth;

        ReturnNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * 1123. Lowest Common Ancestor of Deepest Leaves
     * <p>
     * 865. Smallest Subtree with all the Deepest Nodes
     * <p>
     * two same questions
     * <p>
     * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/ https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
     * <p>
     * my ac answer after learning from video
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lca(root).node;
    }

    private ReturnNode lca(TreeNode root) {
        if (root == null) return new ReturnNode(root, -1);
        if (root.left == null && root.right == null) return new ReturnNode(root, 0);
        ReturnNode l = lca(root.left);
        ReturnNode r = lca(root.right);

        if (l.depth == r.depth) return new ReturnNode(root, l.depth + 1);
        else return new ReturnNode(l.depth < r.depth ? r.node : l.node, Math.max(l.depth, r.depth) + 1);
    }
}
