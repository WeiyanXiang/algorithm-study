package tree.traverse;/**
 * @author Weiyan Xiang on 2021/6/22
 */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBSTs {

    /**
     * 1305. All Elements in Two Binary Search Trees
     * <p>
     * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
     * <p>
     * my ac ans: dfs traverse inorder both tree (L-ROOT-R) and merge it into ans.
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = dfsInorder(root1, new ArrayList<>());
        List<Integer> l2 = dfsInorder(root2, new ArrayList<>());
        return merge(l1, l2);
    }

    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        int i1 = 0, i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1) < l2.get(i2)) {
                res.add(l1.get(i1++));
            } else {
                res.add(l2.get(i2++));
            }
        }
        if (i1 < l1.size()) {
            for (int i = i1; i < l1.size(); i++) res.add(l1.get(i));
        } else {
            for (int i = i2; i < l2.size(); i++) res.add(l2.get(i));
        }
        return res;
    }

    private List<Integer> dfsInorder(TreeNode root, List<Integer> l) {
        if (root == null) return l;
        dfsInorder(root.left, l);
        l.add(root.val);
        dfsInorder(root.right, l);
        return l;
    }
}
