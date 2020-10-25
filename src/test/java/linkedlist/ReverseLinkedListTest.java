package linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Weiyan Xiang on 2020/10/25
 */
public class ReverseLinkedListTest {

    private ReverseLinkedList testObj;

    @Before
    public void setup() {
        testObj = new ReverseLinkedList();
    }

    @Test
    public void should_reverse_list() {
        ListNode root = new ListNode(1);
        ListNode ListNode1 = new ListNode(2);
        ListNode ListNode2 = new ListNode(3);
        ListNode ListNode3 = new ListNode(4);
        ListNode ListNode4 = new ListNode(5);
        root.next = ListNode1;
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode4;
        // act
        ListNode reversedList = testObj.reverseList(root);
        // assert
        assertEquals(5, reversedList.val);
        assertEquals(4, reversedList.next.val);
        assertEquals(3, reversedList.next.next.val);
        assertEquals(2, reversedList.next.next.next.val);
        assertEquals(1, reversedList.next.next.next.next.val);
    }
}