package tree.topdown;

/**
 * @author Weiyan Xiang on 2021/5/16
 */

public class PopulatingNextRightPointers {
    /**
     * 116. Populating Next Right Pointers in Each Node
     * <p>
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
     * <p>
     * my answer: topdown: connect parent.right to parent.next.left
     */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }


    /**
     * my another dfs ans: pass a parent to traverse
     */
    public Node connectMyOwn(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node root, Node pre) {
        if (root == null) return;
        if (pre != null) {
            if (pre.left == root) {
                root.next = pre.right;
            } else {
                root.next = pre.next == null ? null : pre.next.left;
            }
        }
        dfs(root.left, root);
        dfs(root.right, root);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
