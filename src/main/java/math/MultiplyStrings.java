package math;

/**
 * @author Weiyan Xiang on 2021/11/7
 */

public class MultiplyStrings {

    /**
     * 43. Multiply Strings
     * <p>
     * https://leetcode.com/problems/multiply-strings/
     * <p>
     * upvoted idea: normal multiplication simulation. the catch is i+j and i+j+1 are the positions for i and j's
     * multiplication
     */
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();

        int[] total = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // current multiplier plus the previous digits carried over
                int sum = mult + total[i + j + 1];
                total[i + j] += sum / 10;
                total[i + j + 1] = sum % 10;
            }
        }

        String ans = "";
        for (int i = 0; i < total.length; i++) {
            if (total[i] == 0 && ans.length() == 0) continue;
            ans += total[i];
        }
        return ans.isEmpty() ? "0" : ans;
    }
}
