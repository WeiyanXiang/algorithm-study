package search.backtrack;/**
 * @author Weiyan Xiang on 2021/2/10
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLenOfConcatenatedString {
    private int max = 0;

    /**
     * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
     * <p>
     * upvoted ac answer
     */
    public int maxLength(List<String> arr) {
        // combination
        dfs(arr, 0, "");
        return max;
    }

    private void dfs(List<String> arr, int start, String cur) {
        if (start > arr.size()) return;
        if (!isUnique(cur)) {
            return;
        }
        if (isUnique(cur)) {
            max = Math.max(max, cur.length());
        }
        for (int i = start; i < arr.size(); i++) {
            String word = arr.get(i);
            dfs(arr, i + 1, cur + arr.get(i));
        }
    }

    private boolean isUnique(String cur) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < cur.length(); i++) {
            if (set.contains(cur.charAt(i))) return false;
            set.add(cur.charAt(i));
        }
        return true;
    }
}
