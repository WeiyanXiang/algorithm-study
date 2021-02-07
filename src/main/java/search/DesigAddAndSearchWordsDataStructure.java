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
}
