package tree.path;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/12/9
 */
public class BinaryTreePaths {

    /**
     * 257. Binary Tree Paths
     * <p>
     * https://leetcode.com/problems/binary-tree-paths/
     * <p>
     * my own ac answer after learning from upvoted answer
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        traverse(root, ans, "");
        return ans;
    }

    private void traverse(TreeNode root, List<String> ans, String sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans.add(sb + root.val);
        }
        traverse(root.left, ans, sb + root.val + "->");
        traverse(root.right, ans, sb + root.val + "->");
    }
}
