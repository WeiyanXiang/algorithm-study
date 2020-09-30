package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Weiyan Xiang on 2020/9/30
 * <p>
 * Given a Binary Tree, find count of distinct TreeNodes in a root to leaf path with maximum distinct TreeNodes.
 */
public class NumOfDistinctNodesInPath {

    private int r;

    public int pathSum(TreeNode root) {
        if (root == null) return r;
        doCheck(root, new HashSet<>());
        return r;
    }

    private void doCheck(TreeNode root, Set<Integer> p) {
        if (root == null || p.contains(root.val)) {
            r = Math.max(r, p.size());
            return;
        }
        p.add(root.val);
        doCheck(root.left, p);
        doCheck(root.right, p);
        p.remove(root.val);
    }

}
