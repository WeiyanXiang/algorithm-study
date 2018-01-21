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
    public static String longestPalindrome(String s) {
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

    private static String max(String left, String right) {
        return left.length() > right.length() ? left : right;
    }

    public static String getPalindrome(int left, int right, String s) {
        if (right >= s.length())
            return "";
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
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
        System.out.println(longestPalindrome(test1) + " == bb");
        String test2 = "ccabacd";
        System.out.println(longestPalindrome(test2) + " == cabac");
    }

}
