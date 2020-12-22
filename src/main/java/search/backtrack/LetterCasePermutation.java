package search.backtrack;/**
 * @author Weiyan Xiang on 2020/12/21
 */

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    /**
     * 784. Letter Case Permutation
     *
     * https://leetcode.com/problems/letter-case-permutation/
     */
    //@formatter:off
    /**
     /**
        a1b2                i=0, when it's at a, since it's a letter, we have two branches: a, A
     /        \
     a1b2       A1b2        i=1 when it's at 1, we only have 1 branch which is itself
     |          |
     a1b2       A1b2        i=2 when it's at b, we have two branches: b, B
     /  \        / \
     a1b2 a1B2  A1b2 A1B2   i=3  when it's at 2, we only have one branch.
     |    |     |     |
     a1b2 a1B2  A1b2  A1B2  i=4 = S.length(). End recursion, add permutation to ans.

     During this process, we are changing the S char array itself
     */
    //@formatter:on
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        String temp = "";
        dfs(S.toCharArray(), ans, 0);
        return ans;
    }

    private void dfs(char[] s, List<String> ans, int i) {
        if (i == s.length) {
            ans.add(new String(s));
            return;
        }
        if (!Character.isLetter(s[i])) {
            dfs(s, ans, i + 1);
            return;
        }
        s[i] = Character.toUpperCase(s[i]);
        dfs(s, ans, i + 1);
        s[i] = Character.toLowerCase(s[i]);
        dfs(s, ans, i + 1);
    }
}
