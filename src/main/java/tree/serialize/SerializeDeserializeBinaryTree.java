package tree.serialize;

import tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Weiyan Xiang on 2020/12/10
 */
public class SerializeDeserializeBinaryTree {
    private String ans = "";

    /**
     * 297. Serialize and Deserialize Binary Tree
     * <p>
     * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
     * <p>
     * my own ac answer after learning from upvoted answer
     */
    public String serialize(TreeNode root) {
        doSerialize(root);
        return ans;
    }

    private void doSerialize(TreeNode root) {
        ans += (root == null ? "#" : root.val) + ",";
        if (root == null) return;
        doSerialize(root.left);
        doSerialize(root.right);
    }

    // Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return doDeserialize(nodes);
    }

    private TreeNode doDeserialize(LinkedList<String> nodes) {
        String v = nodes.removeFirst();
        if (v.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(v));
        root.left = doDeserialize(nodes);
        root.right = doDeserialize(nodes);
        return root;
    }
}
