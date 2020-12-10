package tree.serialize;

import org.junit.Test;
import tree.TreeNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Weiyan Xiang on 2020/12/10
 */
public class SerializeDeserializeBSTTest {

    @Test
    public void test_se_and_deserialize() {
        SerializeDeserializeBST testObj = new SerializeDeserializeBST();
        TreeNode root = TreeNode.buildTreeFromInts(2, 1, 3);
        // act
        String actualString = testObj.serialize(root);
        // assert
        assertEquals("2,1,3,", actualString);
        // act
        TreeNode actualNode = testObj.deserialize(actualString);
        // assert
        assertTrue(TreeNode.isSameTree(root, actualNode));
    }
}