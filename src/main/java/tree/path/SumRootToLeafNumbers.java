package tree.path;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2020/12/8
 */
public class SumRootToLeafNumbers {

    /**
     * 129. Sum Root to Leaf Numbers
     *
     * https://leetcode.com/problems/sum-root-to-leaf-numbers/
     */
    /**
     * my own ac answer: recursion with backtracking
     */
    int sum = 0;

    public int sumNumbersRecursionWithBackTracking(TreeNode root) {
        if (root == null) return 0;
        doSum(root, 0);
        return sum;
    }

    private void doSum(TreeNode root, int cur) {
        if (root == null) return;
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) sum += cur;
        doSum(root.left, cur);
        doSum(root.right, cur);
        // cur = (cur - root.val) / 10; // this step is can be ignored, it will be called if keeping it but the
        // state of cur is already in stack. so no backtracking happened effectively.
    }


}
