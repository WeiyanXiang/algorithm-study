/**
 * 
 */
package string;

/**
 * @author weiyan.xiang
 * @date 19 Feb 2018
 */
public class StrStr {

    /**
     * Input: haystack = "hello", needle = "ll" Output: 2; Input: haystack =
     * "aaaaa", needle = "bba" Output: -1
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("2 == " + strStr("hello", "ll"));
        System.out.println("-1 == " + strStr("aaaaa", "bba"));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            int a = i, b = 0;
            while (a < haystack.length() && b < needle.length() && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            if (b == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
