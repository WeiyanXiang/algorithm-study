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
     * upvoted ac answer
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        String[] dict = new String[]{
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
        char[] ds = digits.toCharArray();
        List<String> ans = new ArrayList<>();
        ans.add("");
        // i.e. digits are [2 ,3]
        for (int i = 0; i < ds.length; i++) {
            List<String> temp = new ArrayList<>();
            // i.e. "abc", supported letters for current digit
            String supportedLetters = dict[Character.getNumericValue(ds[i])];
            for (String curLetters : ans) {
                for (char letter : supportedLetters.toCharArray()) {
                    temp.add(curLetters + letter);
                }
            }
            ans = temp;
        }
        return ans;
    }


}
