package tree.serialize;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * @author Weiyan Xiang on 2020/12/10
 */
public class SerializeDeserializeBSTGeneralIdea {

    /**
     * 449. Serialize and Deserialize BST
     * <p>
     * https://leetcode.com/problems/serialize-and-deserialize-bst/
     * <p>
     * a more general idea, mark leaf as X so that when decode it can be recog
     */
    String cache = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // preorder
        if (root == null) cache += "X,";
        else {
            cache += root.val + ",";
            serialize(root.left);
            serialize(root.right);
        }
        return cache;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] raw = data.split(",");
        LinkedList<String> nodes = new LinkedList<>();
        for (int i = 0; i < raw.length; i++) nodes.add(raw[i]);
        return dfs(nodes);
    }

    private TreeNode dfs(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        String value = nodes.poll();
        if (value.equals("X")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = dfs(nodes);
        node.right = dfs(nodes);
        return node;
    }
}
