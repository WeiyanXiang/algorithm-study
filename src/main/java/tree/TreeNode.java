/**
 * 
 */
package tree;

import java.util.List;

/**
 * @author weiyan.xiang
 * @date 13 Mar 2018
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static void printListOfList(List<List<Integer>> levelOrder) {
        for (List<Integer> elementList : levelOrder) {
            System.out.print("[");
            for (Integer element : elementList) {
                System.out.print(element + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

}
