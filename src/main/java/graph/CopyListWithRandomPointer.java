package graph;/**
 * @author Weiyan Xiang on 2021/2/17
 */

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 138. Copy List with Random Pointer
     * <p>
     * https://leetcode.com/problems/copy-list-with-random-pointer/
     * <p>
     * upvoted ac ans
     *
     * I developed the idea of Map<Integer, Node> but when node with same int value it wont work.
     * The upvote ans is using Map of key: original Node, copied Node and in second loop, assign both
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // key: original Node; value: Copied node ref
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        // copy all nodes into map
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        // assign next and randome by looping
        Node an = head;
        while (an != null) {
            map.get(an).next = map.get(an.next);
            map.get(an).random = map.get(an.random);
            an = an.next;
        }
        return map.get(head);
    }
}
