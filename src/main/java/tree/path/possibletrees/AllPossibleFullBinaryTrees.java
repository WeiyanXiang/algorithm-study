package tree.path.possibletrees;/**
 * @author Weiyan Xiang on 2021/6/25
 */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    /**
     * https://leetcode.com/problems/all-possible-full-binary-trees/
     * <p>
     * upvoted ac ans: recursion
     */
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        n--;
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode cur = new TreeNode(0);
                    // tricky here, this l and r were being used by different trees, fully correct way is to deep clone
                    cur.left = l;
                    cur.right = r;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
