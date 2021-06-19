package tree.levelorder;/**
 * @author Weiyan Xiang on 2021/6/19
 */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    private int[] cache = new int[101];

    /**
     * 199. Binary Tree Right Side View
     * <p>
     * https://leetcode.com/problems/binary-tree-right-side-view/
     * <p>
     * my ac ans: dfs and always update the array because always dfs the right node in recursion
     */
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        List<Integer> ans = new ArrayList<>();
        for (int c : cache) {
            if (c == 101) ans.add(0);
            else if (c != 0) ans.add(c);
        }
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        cache[level] = root.val == 0 ? 101 : root.val;
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
