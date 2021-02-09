package search;/**
 * @author Weiyan Xiang on 2021/2/7
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesigAddAndSearchWordsDataStructure {
    /**
     * https://leetcode.com/problems/design-add-and-search-words-data-structure/
     * <p>
     * upvoted ac answer:
     */

    Map<Integer, List<String>> map;

    /**
     * Initialize your data structure here.
     */
    public DesigAddAndSearchWordsDataStructure() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int key = word.length();
        if (!map.containsKey(key)) {
            List<String> wl = new ArrayList<String>();
            wl.add(word);
            map.put(key, wl);
        } else {
            map.get(key).add(word);
        }
    }

    public boolean search(String word) {
        int key = word.length();
        if (!map.containsKey(key)) return false;
        List<String> wl = map.get(key);
        for (String w : wl) {
            if (isSame(w, word)) return true;
        }
        return false;
    }

    private boolean isSame(String w, String word) {
        if (w.length() != word.length()) return false;
        for (int i = 0; i < w.length(); i++) {
            if (word.charAt(i) == '.') continue;
            if (w.charAt(i) != word.charAt(i)) return false;
        }
        return true;
    }


    /**
     * Trie DFS AC upvoted answer, importance is on how Trie constructed
     */
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }

    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    // https://www.geeksforgeeks.org/trie-insert-and-search/
    public void addWordTrie(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean searchTrie(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] words, int start, TrieNode node) {
        if (start == words.length) {
            return node.isWord;
        }
        if (words[start] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && dfs(words, start + 1, node.children[i])) {
                    return true;
                }
            }
        } else {
            return node.children[words[start] - 'a'] != null &&
                    dfs(words, start + 1, node.children[words[start] - 'a']);
        }
        return false;
    }

}
