package search;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Weiyan Xiang on 2020/12/29
 */
public class WordLadderTwoTest {

    @Test
    public void findLadders() {
        WordLadderTwo testObj = new WordLadderTwo();
        // act
        List<List<String>> actual = testObj.findLadders("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        // assert
        assertEquals(2, actual.size());
        assertTrue(actual.contains(Arrays.asList("hit", "hot", "dot", "dog", "cog")));
        assertTrue(actual.contains(Arrays.asList("hit", "hot", "lot", "log", "cog")));
    }
}