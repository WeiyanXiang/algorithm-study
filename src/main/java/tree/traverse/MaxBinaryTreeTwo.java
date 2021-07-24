package tree.traverse;/**
 * @author Weiyan Xiang on 2021/4/28
 */

import tree.TreeNode;

public class MaxBinaryTreeTwo {
    /**
     * 998. Maximum Binary Tree II
     * <p>
     * https://leetcode.com/problems/maximum-binary-tree-ii/
     * <p>
     * my ans: BOTTOM UP: return normal node OR return inserted node. only update root.right as node is appended to right.
     */
    /**
     * analysis:
     * <p>
     * the given tree was constructed from an list A (root = Construct(A)). So, List A = new ArrayList(); Suppose B is a
     * copy of A with the value val appended to it. So, B = new ArrayList(A) and B.add(val); The left child of root will
     * be Construct([A[0], A[1], ..., A[i-1]]), The right child of root will be Construct([A[i+1], A[i+2], ...,
     * A[A.length - 1]]). in this case A represent B, B[B.length-1] = val, So. If val is the largest, i = B.length-1,
     * the root node's value is val, i=0 to i-1 are in the left child of root. This explains why when val > root.val,
     * root should be the left child of new node with value val. Else val is not the largest, the new node with value
     * val is always the right child of root.
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            TreeNode newNode = new TreeNode(val);
            // think from the given list, if val is larger then the root should be at left
            newNode.left = root;
            return newNode;
        }
        // Else val is not the largest, the new node with value val is always the right child of root.
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
