package search;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Weiyan Xiang on 2021/2/8
 */
public class DesigAddAndSearchWordsDataStructureTest {

    @Test
    public void add() {
        DesigAddAndSearchWordsDataStructure testObj = new DesigAddAndSearchWordsDataStructure();
        testObj.addWordTrie("bad");
        testObj.addWordTrie("dad");
        testObj.addWordTrie("bcd");

    }
}