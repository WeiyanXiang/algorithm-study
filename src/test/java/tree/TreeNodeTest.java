package tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Weiyan Xiang on 2020/10/25
 */
public class TreeNodeTest {

    @Test
    public void should_buildTreeFromArray() {
        Integer[] inputTree = {2, 1, 3, null, 4, null, 7};
        // act
        TreeNode actual = TreeNode.buildTreeFromArray(inputTree);
        // assert
        assertEquals(2, actual.val);
        assertEquals(1, actual.left.val);
        assertEquals(3, actual.right.val);
        assertEquals(4, actual.left.right.val);
        assertNull(actual.left.left);
        assertEquals(7, actual.right.right.val);
        assertNull(actual.right.left);

        Integer[] anotherInput = {1, 3, 2, 5};
        // act
        TreeNode anotherActual = TreeNode.buildTreeFromArray(anotherInput);
        // assert
        assertEquals(1, anotherActual.val);
        assertEquals(3, anotherActual.left.val);
        assertEquals(2, anotherActual.right.val);
        assertEquals(5, anotherActual.left.left.val);
        assertNull(anotherActual.left.right);
        assertNull(anotherActual.right.left);
        assertNull(anotherActual.right.right);
    }

}