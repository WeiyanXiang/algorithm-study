package tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Weiyan Xiang on 2020/10/25
 */
public class MergeTwoBinaryTreesTest {

    private MergeTwoBinaryTrees testObj = new MergeTwoBinaryTrees();

    @Test
    public void should_merge_two_binary_trees() {
        TreeNode t1_1 = new TreeNode(1);
        TreeNode t1_2 = new TreeNode(3);
        TreeNode t1_3 = new TreeNode(2);
        TreeNode t1_4 = new TreeNode(5);
        t1_1.left = t1_2;
        t1_1.right = t1_3;
        t1_2.left = t1_4;

        TreeNode t2_1 = new TreeNode(2);
        TreeNode t2_2 = new TreeNode(1);
        TreeNode t2_3 = new TreeNode(3);
        TreeNode t2_4 = new TreeNode(4);
        TreeNode t2_5 = new TreeNode(7);
        t2_1.left = t2_2;
        t2_1.right = t2_3;
        t2_2.right = t2_4;
        t2_3.right = t2_5;


        // act
        TreeNode actual = testObj.mergeTrees(t1_1, t2_1);
        // assert
        assertEquals(3, actual.val);
        assertEquals(4, actual.left.val);
        assertEquals(5, actual.right.val);
        assertEquals(5, actual.left.left.val);
        assertEquals(4, actual.left.right.val);
        assertEquals(7, actual.right.right.val);
    }
}