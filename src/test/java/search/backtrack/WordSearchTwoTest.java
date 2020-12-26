package search.backtrack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/12/26
 */
public class WordSearchTwoTest {

    private WordSearchTwo testObj = new WordSearchTwo();

    @Test
    public void findWordsTrie() {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        // act
        List<String> actual = testObj.findWordsTrie(board, words);
        List<String> expected = Arrays.asList("eat", "oath");
        // assert
        Assert.assertEquals(2, actual.size());
        Assert.assertTrue(actual.containsAll(expected));
    }
}