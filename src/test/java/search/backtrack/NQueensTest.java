package search.backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Weiyan Xiang on 2021/1/23
 */
public class NQueensTest {

    @Test
    public void solveNQueens() {
        NQueens testObj = new NQueens();
        // act
        List<List<String>> actual = testObj.solveNQueens(4);
        // assert
        assertEquals(2, actual.size());
        assertTrue(actual.containsAll(Arrays.asList(
                Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
                Arrays.asList("..Q.", "Q...", "...Q", ".Q.."))));
    }
}