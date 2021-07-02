package tree.traverse;/**
 * @author Weiyan Xiang on 2021/7/2
 */

import tree.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {

    /**
     * 652. Find Duplicate Subtrees
     *
     * https://leetcode.com/problems/find-duplicate-subtrees/
     *
     *
     */
    Map<Integer,List<Integer>> map = new HashMap<>();
    Set<TreeNode> ans = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // dfs save a map: key: treenode.val; value: root-left-right-in-string
        dfs(root);
        return new ArrayList<>(ans);
    }

    private void dfs(TreeNode root){
        if(root==null) return;
        List<Integer> curTra = traverseInString(root,new ArrayList<>());
        if(map.containsKey(root.val)&&curTra.equals(map.get(root.val))) {
            ans.add(root);
        }
        map.put(root.val, curTra);
        dfs(root.left);
        dfs(root.right);
    }

    private List<Integer> traverseInString(TreeNode root, List<Integer> list){
        if(root==null) return list;
        list.add(root.val);
        traverseInString(root.left,list);
        traverseInString(root.right,list);
        return list;
    }

}
