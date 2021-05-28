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
    private List<Integer> res = new ArrayList<>();
    private int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root == null) return res;
        if (root.left != null) {
            if (root.left.val != voyage[index]) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;

                res.add(root.val);
            }
        }
        index++;
        flipMatchVoyage(root.left, voyage);
        flipMatchVoyage(root.right, voyage);
        return res.isEmpty() ? Arrays.asList(-1) : res;
    }

}
