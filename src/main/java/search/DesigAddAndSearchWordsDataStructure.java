package search;/**
 * @author Weiyan Xiang on 2021/2/7
 */

import com.sun.xml.internal.bind.v2.TODO;

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
     * Trie DFS AC upvoted answer, importance is on how Trie constructed // https://www.geeksforgeeks.org/trie-insert-and-search/
     */
    class WordDictionary {

        class TrieNode {
            // aphabet array of trieNode
            TrieNode[] children = new TrieNode[26];
            boolean isEnd;
        }

        TrieNode root;

        public WordDictionary() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = root;
            char[] cs = word.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char c = cs[i];
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
                if (i == cs.length - 1) cur.isEnd = true;
            }
        }

        public boolean search(String word) {
            return dfs(word.toCharArray(), root, 0);
        }

        public List<String> getTop5Words(String prefix) {
            return null;
        }

        private boolean dfs(char[] words, TrieNode cur, int start) {
            if (cur == null) return false;
            if (start == words.length) return cur.isEnd;
            if (words[start] == '.') {
                // search for all 26 letters at same level
                for (int i = 0; i < 26; i++) {
                    if (cur.children[i] != null && dfs(words, cur.children[i], start + 1)) return true;
                }
            } else {
                return dfs(words, cur.children[words[start] - 'a'], start + 1);
            }
            return false;
        }


    }

}
