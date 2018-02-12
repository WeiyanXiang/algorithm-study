/**
 * 
 */
package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weiyan.xiang
 * @date 12 Feb 2018
 */
public class TwoSumBST {

    /*
     * Given a Binary Search Tree and a target number, return true if there
     * exist two elements in the BST such that their sum is equal to the given
     * target.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // { 2,7,11,15 };
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        TreeNode rightSubNode = new TreeNode(11);
        rightSubNode.right = new TreeNode(15);
        root.right = rightSubNode;
        System.out.println(findTarget(root, 26));
    }

    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return PreorderTraverseAndProcess(root, k, set);
    }

    private static boolean PreorderTraverseAndProcess(TreeNode node, int k, Set<Integer> set) {
        if (node == null)
            return false;
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return PreorderTraverseAndProcess(node.left, k, set) || PreorderTraverseAndProcess(node.right, k, set);
    }

}
