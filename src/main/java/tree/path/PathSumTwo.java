/**
 *
 */
package tree.path;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiyan.xiang
 * @date 3 Apr 2018
 */
public class PathSumTwo {
    //@formatter:off
	/*
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
		Note: A leaf is a node with no children.
		Example:
		Given the below binary tree and sum = 22,
		
		      5
		     / \
		    4   8
		   /   / \
		  11  13  4
		 /  \    / \
		7    2  5   1
		Return:    
		[
		   [5,4,11,2],
		   [5,8,4,5]
		]
	 */
	//@formatter:on

    /**
     * 113. Path Sum II
     * <p>
     * https://leetcode.com/problems/path-sum-ii/
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        doPathSum(root, sum, 0, ans, new ArrayList<>());
        return ans;
    }

    private void doPathSum(TreeNode root, int sum, int cur, List<List<Integer>> ans, List<Integer> row) {
        if (root == null) return;
        cur += root.val;
        row.add(root.val);
        if (root.left == null && root.right == null && cur == sum) ans.add(new ArrayList<>(row));
        doPathSum(root.left, sum, cur, ans, row);
        doPathSum(root.right, sum, cur, ans, row);
        row.remove(row.size() - 1); // backtrack
    }

    public static void main(String[] args) {

        // @formatter:off
		/*
		 *
		 *
		 *    5
		     / \
		    4   8
		   /   / \
		  11  13  4
		 /  \    / \
		7    2  5   1

		 */
		// @formatter:on
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;

        System.out.println("[[5, 4, 11, 2], [5, 8, 4, 5]] <-> " + new PathSumTwo().pathSum(root, 22));
    }

}
