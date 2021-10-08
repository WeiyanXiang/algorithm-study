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
        assertFalse(trie.startsWith("xxo"));
        assertTrue(trie.startsWith("appl"));
        assertTrue(trie.search("word"));
        assertTrue(trie.search("apple"));
        assertTrue(trie.search("appeal"));
        assertFalse(trie.search("appealxx"));
        assertFalse(trie.search("app"));
    }
}