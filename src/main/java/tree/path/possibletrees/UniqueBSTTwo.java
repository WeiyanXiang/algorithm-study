package tree.path.possibletrees;/**
 * @author Weiyan Xiang on 2021/6/25
 */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTTwo {

    /**
     * 95. Unique Binary Search Trees II
     * <p>
     * https://leetcode.com/problems/unique-binary-search-trees-ii/
     * <p>
     * my ac ans: pick each 1-n as root and dfs left [1,i-1] and right [i+1,n]
     */
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start == end) {
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }
        if (start > end) {
            res.add(null); // 
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
