package tree;/**
 * @author Weiyan Xiang on 2021/8/8
 */

import tree.TreeNode;

public class RecoverBST {


    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevElement = null;

    /**
     * 99. Recover Binary Search Tree
     * <p>
     * https://leetcode.com/problems/recover-binary-search-tree/
     * <p>
     * upvoted ans: keep track of 3 vars. This can also be done using a list to in-order traverse and sort the list and
     * reassign the values back to tree
     */
    public void recoverTree(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && (prevElement != null && prevElement.val >= root.val)) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && (prevElement != null && prevElement.val >= root.val)) {
            secondElement = root;
        }
        prevElement = root;

        // End of "do some business"

        traverse(root.right);
    }
}
