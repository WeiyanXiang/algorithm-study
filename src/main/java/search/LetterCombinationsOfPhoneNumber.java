package search;/**
 * @author Weiyan Xiang on 2020/12/20
 */

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    /**
     * 17. Letter Combinations of a Phone Number
     * <p>
     * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
     * <p>
     * ac answer from upvoted
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        String[] d = new String[]{
                " ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};
        char[] di = digits.toCharArray();
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (int i = 0; i < di.length; i++) {
            List<String> temp = new ArrayList<>();
            String s = d[Character.getNumericValue(di[i])];
            // i.e. "abc"
            for (String aa : ans) {
                for (char ss : s.toCharArray()) {
                    temp.add(aa + ss);
                }
            }
            ans = temp;
        }
        return ans;
    }
}
