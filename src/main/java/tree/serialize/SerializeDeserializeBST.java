package tree.serialize;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * 449. Serialize and Deserialize BST
 * <p>
 * https://leetcode.com/problems/serialize-and-deserialize-bst/submissions/
 * <p>
 * * same question to SerializeDeserializeBSTGeneralIdea
 */
public class SerializeDeserializeBST {
    String cache = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // preorder
        if (root == null) return cache; //because of BST, we can skip null leaf value
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
        return dfs(nodes, -1, 10001);
    }

    private int index = 0;

    private TreeNode dfs(LinkedList<String> nodes, int lo, int hi) {
        if (nodes.isEmpty()) return null;
        int intValue = Integer.valueOf(nodes.peek());
        //because of BST, we can check here to avoid checking out-of-bounce/null values
        /**
         * if when serializing, when root == null, we do cache+="X," then String is not the most compact
         * and we need to handle null values, but we wont need handle below pruning
         */
        if (intValue < lo || intValue > hi) return null;
        nodes.poll();
        TreeNode node = new TreeNode(intValue);
        node.left = dfs(nodes, lo, intValue);
        node.right = dfs(nodes, intValue, hi);
        return node;
    }
}
