package search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2021/1/19
 */
public class WordBreakTwoTest {

    @Test
    public void wordBreak() {
        WordBreakTwo testObj = new WordBreakTwo();
        // act
//        String s = "pineapplepenapple";
//        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
//        List<String> actual = testObj.wordBreak(s, wordDict);
//        // assert
//        Assert.assertEquals(3, actual.size());
//        Assert.assertTrue(actual.containsAll(Arrays.asList(
//                "pine apple pen apple",
//                "pineapple pen apple",
//                "pine applepen apple")));

        // act
        String s2 = "a";
        List<String> wordDict2 = Arrays.asList("a");
        List<String> actual2 = testObj.wordBreak(s2, wordDict2);
        Assert.assertEquals("a", actual2.get(0));
    }
}