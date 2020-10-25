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
        Integer[] input1 = {1, 3, 2, 5};
        Integer[] input2 = {2, 1, 3, null, 4, null, 7};

        TreeNode t1 = TreeNode.buildTreeFromArray(input1);
        TreeNode t2 = TreeNode.buildTreeFromArray(input2);
        // act
        TreeNode actual = testObj.mergeTrees(t1, t2);
        // assert
        assertEquals(3, actual.val);
        assertEquals(4, actual.left.val);
        assertEquals(5, actual.right.val);
        assertEquals(5, actual.left.left.val);
        assertEquals(4, actual.left.right.val);
        assertEquals(7, actual.right.right.val);
    }
}