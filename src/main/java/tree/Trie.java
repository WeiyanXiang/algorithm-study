package tree;

/**
 * @author Weiyan Xiang on 2021/10/8
 */

public class Trie {

    private Trie[] kids;
    private boolean isWord;


    public Trie() {
        this.kids = new Trie[26];
    }

    public void insert(String word) {
        char[] words = word.toCharArray();
        Trie root = this;
        for (int i = 0; i < words.length; i++) {
            if (root.kids[words[i] - 'a'] == null) {
                root.kids[words[i] - 'a'] = new Trie();
            }
            root = root.kids[words[i] - 'a'];
        }
        root.isWord = true;
    }


    public boolean search(String word) {
        return dfs(word, 0, this, true);
    }

    private boolean dfs(String word, int index, Trie root, boolean needToFindWord) {
        if (!needToFindWord && word.length() == index) return true;
        if (word.length() == index && (needToFindWord && root.isWord)) return true;
        if (index >= word.length()) return false;
        if (root.kids[word.charAt(index) - 'a'] == null) return false;
        return dfs(word, index + 1, root.kids[word.charAt(index) - 'a'], needToFindWord);
    }

    public boolean startsWith(String prefix) {
        return dfs(prefix, 0, this, false);
    }
}
