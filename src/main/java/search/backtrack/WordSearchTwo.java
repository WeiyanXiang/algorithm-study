package search.backtrack;/**
 * @author Weiyan Xiang on 2020/12/26
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchTwo {
    /**
     * 212. Word Search II
     * <p>
     * https://leetcode.com/problems/word-search-ii/
     * <p>
     * semi-optimal: very similar to WordSearch, just loop it to check whether find word.
     */
    public List<String> findWordsNormal(char[][] board, String[] words) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> ans = new HashSet<String>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                for (String word : words) {
                    if (dfs(board, word, r, c, 0, visited) && !ans.contains(word)) ans.add(word);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i, boolean[][] visited) {
        if (i == word.length()) return true;
        if (r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1) return false;
        if (!visited[r][c] && word.charAt(i) == board[r][c]) {
            visited[r][c] = true;
            boolean found =
                    dfs(board, word, r + 1, c, i + 1, visited) ||
                    dfs(board, word, r - 1, c, i + 1, visited) ||
                    dfs(board, word, r, c + 1, i + 1, visited) ||
                    dfs(board, word, r, c - 1, i + 1, visited);
            // backtrack
            visited[r][c] = false;
            return found;
        }
        return false;
    }

    /**
     * using a Trie to efficiently solve,
     *
     * to help understand trie:
     * so prefix path check can consider to use trie
     *
     * https://www.youtube.com/watch?v=AXjmTQ8LEoI&ab_channel=TusharRoy-CodingMadeSimple
     */
    private Set<String> ans;
    private boolean[][] visited;

    public List<String> findWordsTrie(char[][] board, String[] words) {
        Trie trie = new Trie();
        ans = new HashSet<>();
        for (String word : words) trie.insert(word);
        visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfsTrie(board, "", r, c, trie);
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfsTrie(char[][] board, String prefix, int r, int c, Trie trie) {
        if (r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1) return;
        if (visited[r][c]) return;
        prefix += board[r][c];
        if (!trie.startsWith(prefix)) return;
        if (trie.search(prefix)) ans.add(prefix);
        visited[r][c] = true;
        dfsTrie(board, prefix, r + 1, c, trie);
        dfsTrie(board, prefix, r - 1, c, trie);
        dfsTrie(board, prefix, r, c + 1, trie);
        dfsTrie(board, prefix, r, c - 1, trie);
        visited[r][c] = false;
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";

        // Initialize your data structure here.
        public TrieNode() {
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return node.item.equals(word);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
    }

}
