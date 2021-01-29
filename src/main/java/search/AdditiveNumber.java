package search;

/**
 * @author Weiyan Xiang on 2021/1/29
 */

public class AdditiveNumber {
    /**
     * 306. Additive Number
     * <p>
     * https://leetcode.com/problems/additive-number/
     * <p>
     * upvoted answer with some pruning
     */
    public boolean isAdditiveNumber(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            long a = parse(s.substring(0, i));
            if (a == -1) continue;
            for (int j = i + 1; j < n; j++) {
                long b = parse(s.substring(i, j));
                if (b == -1) continue;
                if (dfs(a, b, s.substring(j))) return true;
            }
        }
        return false;
    }

    private boolean dfs(long a, long b, String s) {
        if (s.length() == 0) return true;
        for (int i = 1; i <= s.length(); i++) {
            long c = parse(s.substring(0, i));
            if (c == -1) continue;
            if (c == a + b && dfs(b, c, s.substring(i))) return true;
        }
        return false;
    }

    private long parse(String num) {
        if (!num.equals("0") && num.startsWith("0")) return -1;
        if (num.length() == 0) return -1;
        return num.length() <= 16 ? Long.valueOf(num) : -1;
    }

}
