/**
 * 
 */
package string;

/**
 * @author weiyan.xiang
 * @date 14 Jan 2018
 */
public class LongestPalindromicSubstring {

    /**
     * central around method. efficiency: O(n^2) space: O(1)
     * 
     * @param s
     * @return
     */
    public static String longestPalindromeCentral(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        String answer = "";
        for (int i = 0; i < n; i++) {
            String subPalindrome = max(getPalindrome(i, i, s), getPalindrome(i, i + 1, s));
            answer = max(answer, subPalindrome);
        }
        return answer;
    }

    public static String longestPalindromeReverse(String input) {
        StringBuilder builder = new StringBuilder();
        builder.append(input);
        String reversedInput = builder.reverse().toString();
        /*
         * aebbecd dcebbea
         */
        return "";
    }

    private static String max(String left, String right) {
        return left.length() > right.length() ? left : right;
    }

    private static String getPalindrome(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(++left, right);
    }

    /*
     * added main method
     */
    public static void main(String[] args) {
        String test1 = "cbbd";
        System.out.println(longestPalindromeCentral(test1) + " == bb");
        String test2 = "ccabacd";
        System.out.println(longestPalindromeCentral(test2) + " == cabac");
    }

}
