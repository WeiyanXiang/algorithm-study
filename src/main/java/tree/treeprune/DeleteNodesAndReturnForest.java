package tree.treeprune;/**
 * @author Weiyan Xiang on 2021/4/21
 */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    /**
     * 1110. Delete Nodes And Return Forest
     * <p>
     * https://leetcode.com/problems/delete-nodes-and-return-forest/
     * <p>
     * my own ac ans: L-R-Return bottom-up
     */
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteSet = new HashSet<>();
        for (int e : to_delete) deleteSet.add(e);
        if (!deleteSet.contains(root.val)) ans.add(root);
        dfs(root, deleteSet);
        return ans;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> toDelete) {
        if (node == null) return null;
        node.left = dfs(node.left, toDelete);
        node.right = dfs(node.right, toDelete);
        if (toDelete.contains(node.val)) {
            if (node.left != null) ans.add(node.left);
            if (node.right != null) ans.add(node.right);
            return null;
        }

        return node;
    }
}
