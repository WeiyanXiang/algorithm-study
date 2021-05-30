package tree.traverse.topdown;/**
 * @author Weiyan Xiang on 2021/5/28
 */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {
    /**
     * 971. Flip Binary Tree To Match Preorder Traversal
     * <p>
     * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
     */
    List<Integer> res = new ArrayList<>();
    int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        dfs(root, voyage);
        return dfs(root, voyage) ? res : Arrays.asList(-1);
    }

    private boolean dfs(TreeNode root, int[] v) {
        if (root == null) return true;
        // compare current node value, which can be coming from the swapped subtree
        if (i < v.length && root.val != v[i]) return false;
        i++;
        // compare left node and swap
        if (root.left != null && i < v.length && root.left.val != v[i]) {
            res.add(root.val);
            return dfs(root.right, v) && dfs(root.left, v);
        }
        return dfs(root.left, v) && dfs(root.right, v);
    }
}
