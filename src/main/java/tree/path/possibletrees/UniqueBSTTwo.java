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
     * upvoted ans: pick each 1-n as root and dfs left [1,i-1] and right [i+1,n]
     * <p>
     * I start by noting that 1..n is the in-order traversal for any BST with nodes 1 to n. So if I pick i-th node as my
     * root, the left subtree will contain elements 1 to (i-1), and the right subtree will contain elements (i+1) to n.
     * I use recursive calls to get back all possible trees for left and right subtrees and combine them in all possible
     * ways with the root.
     */
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int l, int r) {
        List<TreeNode> list = new ArrayList<>();
        if (l > r) {
            // to handle when there's a nil
            list.add(null);
        }
        // pick each i as root, from start to end, and work out generating the BST
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = dfs(l, i - 1);
            List<TreeNode> right = dfs(i + 1, r);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftNode;
                    cur.right = rightNode;
                    list.add(cur);
                }
            }
        }
        return list;
    }
}
