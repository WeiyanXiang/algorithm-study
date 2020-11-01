package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Weiyan Xiang on 2020/11/1
 */
public class ReverseLinkedListBetweenTest {

    private ReverseLinkedListBetween testObj = new ReverseLinkedListBetween();

    @Test
    public void should_reverseBetween_normal() {
        int[] inputs = {1, 2, 3, 4, 5};
        ListNode root = ListNode.buildLinkedListFromArray(inputs);
        // act
        /**
         * Input: 1->2->3->4->5->NULL, m = 2, n = 4
         * Output: 1->4->3->2->5->NULL
         */
        ListNode actual = testObj.reverseBetween(root, 2, 4);
        // assert
        assertEquals(1, actual.val);
        assertEquals(4, actual.next.val);
        assertEquals(3, actual.next.next.val);
        assertEquals(2, actual.next.next.next.val);
        assertEquals(5, actual.next.next.next.next.val);
    }

    @Test
    public void should_reverseBetween_single_index() {
        int[] inputs = {3, 5};
        ListNode root = ListNode.buildLinkedListFromArray(inputs);
        // act
        ListNode actual = testObj.reverseBetween(root, 1, 1);
        // assert
        assertEquals(3, actual.val);
        assertEquals(5, actual.next.val);

    }
}