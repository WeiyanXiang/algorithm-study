package tree.traverse;

import org.junit.Assert;
import org.junit.Test;
import tree.TreeNode;
import tree.path.SumRootToLeafNumbers;

/**
 * @author Weiyan Xiang on 2020/12/8
 */
public class SumRootToLeafNumbersTest {

    @Test
    public void sumNumbersRecursionWithBackTracking() {
        TreeNode root = TreeNode.buildTreeFromInts(1, 2, 3, 4, 5, 6, 7, 8);
        SumRootToLeafNumbers testObj = new SumRootToLeafNumbers();
        // assert
        Assert.assertEquals(1646, testObj.sumNumbersRecursionWithBackTracking(root));
    }
}