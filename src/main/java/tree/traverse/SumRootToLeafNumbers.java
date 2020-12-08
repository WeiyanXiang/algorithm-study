package tree.traverse;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
        // cur = (cur - root.val) / 10; // this step is can be ignored, it will be called if keeping it but the state of cur is already in stack. so no backtracking happened effectively.
    }

    /**
     * my own ac slow answer: using 2d list to store paths and loop again to calculate result
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<List<Integer>> ans = new ArrayList<>();
        doPathSum(root, 0, ans, new ArrayList<>());
        int sumNum = 0;
        for (List<Integer> row : ans) {
            int cur = 0;
            for (Integer v : row) {
                cur = cur * 10 + v;
            }
            sumNum += cur;
        }
        return sumNum;
    }

    private void doPathSum(TreeNode root, int cur, List<List<Integer>> ans, ArrayList<Integer> row) {
        if (root == null) return;
        row.add(root.val);
        if (root.left == null && root.right == null) ans.add(new ArrayList<>(row));
        doPathSum(root.left, cur, ans, row);
        doPathSum(root.right, cur, ans, row);
        row.remove(row.size() - 1); // backtrack
    }


}
