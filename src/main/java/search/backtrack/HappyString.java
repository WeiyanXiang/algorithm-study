package search.backtrack;/**
 * @author Weiyan Xiang on 2021/1/14
 */

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class HappyString {

    /**
     * 1415. The k-th Lexicographical String of All Happy Strings of Length n
     * <p>
     * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
     * <p>
     * AC normal answer: generate valid permutations and get k-th item
     */
    public String getHappyString(int n, int k) {
        char[] chars = {'a', 'b', 'c'};
        List<String> ans = new ArrayList<>();
        dfs(chars, n, "", ans);
        return k > ans.size() ? "" : ans.get(k - 1);
    }

    private void dfs(char[] chars, int n, String cur, List<String> ans) {
        if (n == 0) {
            ans.add(cur);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (cur.length() > 0 && cur.charAt(cur.length() - 1) == c) continue;
            dfs(chars, n - 1, cur + c, ans);
        }
    }
}
