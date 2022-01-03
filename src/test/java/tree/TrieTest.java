package tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Weiyan Xiang on 2021/10/8
 */
public class TrieTest {

    @Test
    public void insert() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("appeal");
        trie.insert("word");
        assertTrue(trie.startsWith("appe"));
        assertTrue(trie.startsWithDfs("appe"));

        assertFalse(trie.startsWith("xxo"));
        assertFalse(trie.startsWithDfs("xxo"));

        assertTrue(trie.startsWith("appl"));
        assertTrue(trie.startsWithDfs("appl"));

        assertTrue(trie.search("word"));
        assertTrue(trie.searchDfs("word"));

        assertTrue(trie.search("apple"));
        assertTrue(trie.searchDfs("apple"));

        assertTrue(trie.search("appeal"));
        assertTrue(trie.searchDfs("appeal"));

        assertFalse(trie.search("appealxx"));
        assertFalse(trie.searchDfs("appealxx"));

        assertFalse(trie.search("app"));
        assertFalse(trie.searchDfs("app"));
    }

}