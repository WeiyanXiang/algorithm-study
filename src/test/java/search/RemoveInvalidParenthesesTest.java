package search;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Weiyan Xiang on 2020/12/24
 */
public class RemoveInvalidParenthesesTest {

    private RemoveInvalidParentheses testObj = new RemoveInvalidParentheses();

    @Test
    public void removeInvalidParentheses() {
        // act
        List<String> actual = testObj.removeInvalidParentheses("(a)())()");
        // assert
        assertEquals(2, actual.size());
        assertTrue(actual.containsAll(Arrays.asList("(a())()", "(a)()()")));

    }

    @Test
    public void isValid() {
        // act
        assertFalse(testObj.isValid("()()()("));
        assertFalse(testObj.isValid("()()()(a))"));
        assertFalse(testObj.isValid("()((()("));
        assertFalse(testObj.isValid("(()()(a)("));
        assertTrue(testObj.isValid("(())()(a)()"));
        assertFalse(testObj.isValid("(a)())("));
    }
}