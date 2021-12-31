package twopointers;/**
 * @author Weiyan Xiang on 2021/12/31
 */

import java.util.*;

public class LastSubstringInLexOrder {

    /**
     * 1163. Last Substring in Lexicographical Order
     * <p>
     * https://leetcode.com/problems/last-substring-in-lexicographical-order/
     * <p>
     * upvoted ans: 2 pointers
     */
    public String lastSubstring(String s) {
        // k tracks when there are duplicate max letter
        int i = 0, j = 1, k = 0;
        while (j + k < s.length()) {
            char c = s.charAt(i + k), d = s.charAt(j + k);
            if (c == d) {
                k++;
                continue;
            } else if (c > d) {
                j = j + k + 1;
            } else {
                i = i + k + 1;
            }
            if (i == j) {
                j = j + 1;
            }
            k = 0;
        }
        return s.substring(i);
    }
}
