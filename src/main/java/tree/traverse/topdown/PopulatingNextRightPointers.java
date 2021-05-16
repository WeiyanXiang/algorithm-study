package tree.traverse.topdown;

/**
 * @author Weiyan Xiang on 2021/5/16
 */

public class PopulatingNextRightPointers {
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

    /**
     * 116. Populating Next Right Pointers in Each Node
     * <p>
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
     * <p>
     * my answer: topdown: connect parent.right  to parent.next.left
     */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) root.left.next = root.right;
        if (root.right != null) root.right.next = root.next != null ? root.next.left : null;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
