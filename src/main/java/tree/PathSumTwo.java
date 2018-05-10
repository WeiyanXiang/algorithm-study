/**
 * 
 */
package tree;

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
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> answer = new ArrayList<>();
		generatePathSum(root, sum, answer, new ArrayList<>());
		return answer;
	}

	public static void generatePathSum(TreeNode node, int sum, List<List<Integer>> answer, List<Integer> path) {
		if (node == null) {
			return;
		}
		if (node.left != null || node.right != null) {

		}
		if (node.val == sum && node.left == null && node.right == null) {
			path.add(node.val);
			answer.add(path);
			return;
		} else if (node.left != null || node.right != null) {
		} else {
			// return false;
		}
	}

	public static void main(String[] args) {
		// @formatter:off
		/*
		 * 5 / \ 4 18 / \ / \ 11 12 4 23
		 */
		// @formatter:on
		TreeNode root = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(18);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(12);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(23);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		System.out.println(pathSum(root, 27));
	}

}
