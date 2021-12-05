package tree;

/**
 * @author Weiyan Xiang on 2021/10/8
 */

/**
 * 208. Implement Trie (Prefix Tree)
 * <p>
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * <p>
 * build a Trie / prefix tree
 */
public class Trie {

    Trie[] children = new Trie[26];
    boolean isEnd;


    public Trie() {
    }

    public void insert(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Trie();
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isEnd;
    }


    public boolean startsWith(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    public boolean searchDfs(String word) {
        return dfs(word.toCharArray(), 0, this);
    }

    private boolean dfs(char[] cs, int start, Trie cur) {
        if (cur == null) return false;
        if (start == cs.length) return cur.isEnd;
        return dfs(cs, start + 1, cur.children[cs[start] - 'a']);
    }

    public boolean startsWithDfs(String prefix) {
        return dfsStartWith(prefix.toCharArray(), 0, this);
    }

    private boolean dfsStartWith(char[] cs, int start, Trie cur) {
        if (cur != null && start == cs.length) return true;
        if (cur == null) return false;
        if (start >= cs.length) return false;
        return dfsStartWith(cs, start + 1, cur.children[cs[start] - 'a']);
    }
}
