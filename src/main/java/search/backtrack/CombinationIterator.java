package search.backtrack;/**
 * @author Weiyan Xiang on 2021/2/12
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {

    /**
     * 1286. Iterator for Combination
     * <p>
     * https://leetcode.com/problems/iterator-for-combination/
     * <p>
     * my own ac answer
     */
    private int curIndex = 0;
    private List<String> list = new ArrayList<>();

    public CombinationIterator(String characters, int k) {
        dfs(characters, k, 0, "");
    }

    private void dfs(String s, int k, int start, String cur) {
        if (cur.length() == k) {
            list.add(cur);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            dfs(s, k, i + 1, cur + s.charAt(i));
        }
    }

    public String next() {
        // combination
        return list.get(curIndex++);
    }

    public boolean hasNext() {
        return list.size() > curIndex;
    }
}
