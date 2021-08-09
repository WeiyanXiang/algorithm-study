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
     * my ac ans: convert sorted linkedlist to sorted list and build
     */
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return dfs(list, 0, list.size() - 1);
    }

    private TreeNode dfs(List<Integer> list, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(list, l, mid - 1);
        root.right = dfs(list, mid + 1, r);
        return root;
    }
}
