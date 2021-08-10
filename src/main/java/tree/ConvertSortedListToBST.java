package tree;/**
 * @author Weiyan Xiang on 2021/8/9
 */

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBST {
    /**
     * 109. Convert Sorted List to Binary Search Tree
     * <p>
     * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
     * <p>
     * upvoted ans: 2 pointers: fast is 2* slow
     */
    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head, null);
    }

    private TreeNode dfs(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // now slow becomes the mid since it is half speed of fast
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(head, slow);
        root.right = dfs(slow.next, tail);
        return root;
    }

    /**
     * my ac ans: Not fastest, convert sorted linkedlist to sorted list and build
     */
    public TreeNode sortedListToBSTNotFastest(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return dfsBuild(list, 0, list.size() - 1);
    }

    private TreeNode dfsBuild(List<Integer> list, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfsBuild(list, l, mid - 1);
        root.right = dfsBuild(list, mid + 1, r);
        return root;
    }
}
