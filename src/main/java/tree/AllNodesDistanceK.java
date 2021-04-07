package tree;/**
 * @author Weiyan Xiang on 2021/4/7
 */

import java.util.*;

public class AllNodesDistanceK {
    /**
     * 863. All Nodes Distance K in Binary Tree
     * 
     * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, target, K, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, TreeNode t, int k, int c, List<Integer> ans){
        if(c==k) {
            ans.add(t.val);
            return;
        }
        if(t.left!=null) dfs(root,t.left,k,c+1,ans);
        if(t.right!=null) dfs(root,t.right,k,c+1,ans);
    }
}
