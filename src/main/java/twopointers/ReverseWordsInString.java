package twopointers;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Weiyan Xiang on 2021/10/21
 */

public class ReverseWordsInString {

    /**
     * 151. Reverse Words in a String
     * <p>
     * https://leetcode.com/problems/reverse-words-in-a-string/
     * <p>
     * initial slow ac ans
     */
    public String reverseWords(String s) {
        String[] res = s.trim().split("\\s+");
        reverse(res);
        String ans = "";
        for (int i = 0; i < res.length - 1; i++) {
            ans += res[i] + " ";
        }
        ans += res[res.length - 1];
        return ans;
    }

    private void reverse(String[] res) {
        int l = 0, r = res.length - 1;
        while (l < r) {
            String temp = res[l];
            res[l] = res[r];
            res[r] = temp;
            l++;
            r--;
        }
    }

    /**
     * upvoted, out of box methods
     */
    public String reverseWordsUpvoted(String s) {
        String[] raw = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(raw));
        return String.join(" ", raw);
    }

}
