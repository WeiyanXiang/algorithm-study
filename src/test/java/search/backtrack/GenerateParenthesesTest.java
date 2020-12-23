package search.backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Weiyan Xiang on 2020/12/23
 */
public class GenerateParenthesesTest {

    @Test
    public void generateParenthesis() {
        GenerateParentheses testObj = new GenerateParentheses();
        // act
        List<String> actual = testObj.generateParenthesis(2);
        List<String> expected = Arrays.asList("()()", "(())");
        assertEquals(2, actual.size());
        assertTrue(actual.containsAll(expected));
    }
}