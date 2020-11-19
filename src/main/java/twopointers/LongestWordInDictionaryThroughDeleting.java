package twopointers;

import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/18
 */
public class LongestWordInDictionaryThroughDeleting {
    /**
     * 524. Longest Word in Dictionary through Deleting
     * <p>
     * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
     */
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        for (String ds : d) {
            if (containsAllByOrder(s, ds)) {
                if (ds.length() > ans.length()) {
                    ans = ds;
                } else if (ds.length() == ans.length()) {
                    ans = ans.compareTo(ds) > 0 ? ds : ans;
                } else {
                    ans = ans;
                }
            }
        }
        return ans;
    }

    private boolean containsAllByOrder(String s, String ds) {
        int i = 0, j = 0;
        while (i < s.length() && j < ds.length()) {
            if (s.charAt(i) == ds.charAt(j)) {
                j++;
            }
            i++;
        }
        if (j < ds.length()) return false;
        return true;
    }
}
