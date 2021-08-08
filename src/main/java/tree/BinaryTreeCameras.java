package tree;/**
 * @author Weiyan Xiang on 2020/12/15
 */

import tree.TreeNode;

public class BinaryTreeCameras {
    int ans = 0;

    /**
     * 968. Binary Tree Cameras
     * <p>
     * https://leetcode.com/problems/binary-tree-cameras/
     *
     * mostly learnt from https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC%2B%2BPython-Greedy-DFS
     * explanation:
     *
     * If we set a camera at the leaf, the camera can cover the leaf and its parent.
     * If we set a camera at its parent, the camera can cover the leaf, its parent and its sibling.
     *
     * We can see that the second plan is always better than the first.
     * Now we have only one option, set up camera to all leaves' parent.
     *
     * Here is our greedy solution:
     *
     * Set cameras on all leaves' parents, then remove all covered nodes.
     * Repeat step 1 until all nodes are covered.
     *
     *
     * Apply a recursion function dfs.
     * Return 0 if it's a leaf.
     * Return 1 if it's a parent of a leaf, with a camera on this node.
     * Return 2 if it's covered, without a camera on this node.
     *
     * For each node,
     * if it has a child, which is leaf (node 0), then it needs camera.
     * if it has a child, which is the parent of a leaf (node 1), then it's covered.
     *
     * If it needs camera, then res++ and we return 1.
     * If it's covered, we return 2.
     * Otherwise, we return 0.
     */
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        return (dfs(root) == 0 ? 1 : 0) + ans;
    }

    /**
    check the child l/r:
    if leaf / 0 -> means it is the parent of a leaf, install camera, so return 1.
    if covered / 1 -> means it (the child) is installed with camera, the as the parent it is covered, so return 2.
    **/
    private int dfs(TreeNode root) {
        // check the child: if it is leaf
        if (root == null) return 2;
        int l = dfs(root.left), r = dfs(root.right);
        // if the child l/r is leaf/0, then install camera: ans++, then return 1 to indicate that it is parent of leaf.
        if (l == 0 || r == 0) {
            ans++;
            return 1;
        }
        // if the child l/r is parent of leaf which means this child has a camera, then current node is covered, return 2
        if (l == 1 || r == 1) return 2;
        // else the child l/r is 2 (which mean from first step returned 2), meaning it is a leaf, then return 0
        return 0;
    }
}
