package search;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author Weiyan Xiang on 2020/12/26
 */
public class WordLadderTest {

    @Test
    public void testLadderLength() {
        WordLadder testObj = new WordLadder();

        // act
//        int actual = testObj.ladderLength("qa", "sq",
//                Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
//                        "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po",
//                        "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb",
//                        "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di",
//                        "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn",
//                        "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"));

//        int actual = testObj.ladderLength("hit", "cog",
//                Arrays.asList("hot", "hit", "cog", "dot", "dog"));


        int actual = testObj.ladderLength("hit", "cog",
                Arrays.asList("hot", "cog", "dot", "dog", "hit", "lot", "log"));

        // assert
        assertEquals(5, actual);

    }

}