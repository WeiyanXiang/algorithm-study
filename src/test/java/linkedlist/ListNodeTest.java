package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Weiyan Xiang on 2020/11/1
 */
public class ListNodeTest {

    @Test
    public void buildLinkedListFromArray() {
        // act & assert
        int[] linkedListArray = {1, 2, 3, 4};
        ListNode actual = ListNode.buildLinkedListFromArray(linkedListArray);
        assertEquals(1, actual.val);
        assertEquals(2, actual.next.val);
        assertEquals(3, actual.next.next.val);
        assertEquals(4, actual.next.next.next.val);
        assertNull(actual.next.next.next.next);
    }
}