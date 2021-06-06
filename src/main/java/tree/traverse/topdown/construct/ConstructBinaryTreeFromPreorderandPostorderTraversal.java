package tree.traverse.topdown.construct;/**
 * @author Weiyan Xiang on 2021/6/5
 */

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderandPostorderTraversal {

    /**
     * 889. Construct Binary Tree from Preorder and Postorder Traversal
     * <p>
     * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
     * <p>
     * my ac answer: preorder is ROOT-L-R so to split postorder (L-R-ROOT), find the root index and then +1 to get the
     * left end index
     */
    private int preindex = 0;
    Map<Integer, Integer> postMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for (int i = 0; i < post.length; i++) {
            postMap.put(post[i], i);
        }
        return dfsBuild(pre, 0, pre.length - 1);
    }

    private TreeNode dfsBuild(int[] pre, int l, int r) {
        if (l > r) return null;
        TreeNode rootNode = new TreeNode(pre[preindex]);
        preindex++;
        if (l == r) return rootNode; // return the root
        int mid = postMap.get(pre[preindex]);
        rootNode.left = dfsBuild(pre, l, mid);
        rootNode.right = dfsBuild(pre, mid + 1, r - 1);
        return rootNode;
    }


}
