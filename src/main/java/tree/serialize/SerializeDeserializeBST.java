package tree.serialize;

import tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Weiyan Xiang on 2020/12/10
 */
public class SerializeDeserializeBST {
    String ans = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        doSerialize(root);
        return ans;
    }

    private void doSerialize(TreeNode root) {
        if (root == null) return;
        ans += root.val + ",";
        doSerialize(root.left);
        doSerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        LinkedList<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(data.split(",")));
        return doDeserialize(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode doDeserialize(LinkedList<String> list, int lo, int hi) {
        if (list.isEmpty()) return null;
        String peek = list.peek();
        int v = Integer.valueOf(peek);
        // below is because otherwise the tree will go deeper instead of obeying right BST rule
        if (v < lo || v > hi) return null;
        list.poll();
        TreeNode root = new TreeNode(v);
        root.left = doDeserialize(list, lo, v);
        root.right = doDeserialize(list, v, hi);
        return root;
    }
}
