package tree;/**
 * @author Weiyan Xiang on 2021/12/14
 */

import java.util.*;

public class RangeSumOfBST {

    /**
     * https://leetcode.com/problems/range-sum-of-bst/
     * <p>
     * https://leetcode.com/problems/range-sum-of-bst/
     * <p>
     * my ac ans: dfs
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        if (root.val < low) return right;
        if (root.val > high) return left;
        else return left + right + root.val;
    }

}
