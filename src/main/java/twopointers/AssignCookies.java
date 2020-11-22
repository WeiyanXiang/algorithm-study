package twopointers;

import java.util.Arrays;

/**
 * @author Weiyan Xiang on 2020/11/22
 */
public class AssignCookies {

    /**
     * 455. Assign Cookies
     * <p>
     * https://leetcode.com/problems/assign-cookies/
     */
    public int findContentChildren(int[] g, int[] s) {
        // store s into a treeMap and update it during scanning g
        Arrays.sort(g);
        Arrays.sort(s);
        int si = 0, count = 0;
        for (int i = 0; i < g.length; i++) {
            while (si < s.length && s[si] < g[i]) {
                si++;
            }
            if (si < s.length) {
                count++;
                si++;
            }
        }
        return count;
    }
}
