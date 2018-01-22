/**
 * 
 */
package string;

/**
 * @author weiyan.xiang
 * @date 22 Jan 2018
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String answer = strs[0];
        for (String str : strs) {
            answer = getCommonPrefix(answer, str);
        }
        return answer;

    }

    public String getCommonPrefix(String base, String right) {
        int i = 0;
        int minLen = Math.min(base.length(), right.length());
        while (base != "" && i < minLen) {
            if (base.charAt(i) == right.charAt(i)) {
                i++;
            } else {
                return base.substring(0, i);
            }
        }
        return base.length() < right.length() ? base : right;
    }

}
