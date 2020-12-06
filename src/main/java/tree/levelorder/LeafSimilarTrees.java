package tree.levelorder;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2020/12/6
 */
public class LeafSimilarTrees {
    /**
     * 872. Leaf-Similar Trees
     * <p>
     * https://leetcode.com/problems/leaf-similar-trees/
     * <p>
     * my own ac answer:
     */
    StringBuilder r1 = new StringBuilder(), r2 = new StringBuilder();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeaf(root1, r1);
        getLeaf(root2, r2);
        return r1.toString().equals(r2.toString());
    }

    private void getLeaf(TreeNode node, StringBuilder ans) {
        if (node == null) return;
        if (node.left == null && node.right == null) ans.append(node.val + ",");
        getLeaf(node.left, ans);
        getLeaf(node.right, ans);
    }
}
