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
     * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
     * <p>
     * my ac answer after learning from video
     */
    /**
     * The question is unclear. For example, if we did not have nodes 7 and 4, the answer would be TreeNode(3). If we
     * did not have node 4, the answer would be TreeNode(7) and not TreeNode(2). Similarly, if we did not have 7, the
     * answer would be TreeNode(4) and not TreeNode(2).
     * <p>
     * Intuitively, we should be traversing from the children to the parent and calculate the height from bottom. So the
     * null nodes would have height 0. The leaf nodes would have the height 1 and the root would have the max height.
     * <p>
     * At each node, we keep a pair<height_of_node_from_bottom, node>. At a given node, if we realize that the
     * leftHeight == rightHeight, it means we have found the deepest subtree rooted at node. If leftHeight >
     * rightHeight, it means the deepest subtree must be rooted at left child. If rightHeight > leftHeight, it means the
     * deepest subtree must be rooted at right child.
     * <p>
     * Which traversal allows us to traverse from bottom-up? Postorder! So we use it in the code.
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
