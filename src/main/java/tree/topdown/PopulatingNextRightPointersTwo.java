package tree.topdown;

/**
 * @author Weiyan Xiang on 2021/5/21
 */

public class PopulatingNextRightPointersTwo {
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
     * 117. Populating Next Right Pointers in Each Node II
     * <p>
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
     */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            if (root.right != null) root.left.next = root.right;
            else root.left.next = getNextLeftMost(root.next);
        }
        if (root.right != null) {
            root.right.next = getNextLeftMost(root.next);
        }
        // why right first then left?
        /**
         * Lets first be clear on what fnext means. fnext is essentially "recursively find the next left most child".
         * Since we need to find "next" left most, we should call right first to make sure the nexts(on the right side)
         * are already well connected, otherwise there would be gap in calling fnext.
         *
         * consider this:
         *
         *        1  ->   2
         *      /  \     / \
         *     3 -> 4 ->5   6
         *    /              \
         *  7                 8
         *
         *  if recursively call left first, 7 can not find next node
         */
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNextLeftMost(Node root) {
        if (root == null) return null;
        if (root.left != null) return root.left;
        if (root.right != null) return root.right;
        return getNextLeftMost(root.next);
    }

}
