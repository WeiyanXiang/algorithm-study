/**
 *
 */
package string;

/**
 * @author weiyan.xiang
 * @date 19 Feb 2018
 */
public class FirstNeedleInHayStack {

    /**
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * <p>
     * Input: haystack = "hello", needle = "ll" Output: 2;
     * <p>
     * Input: haystack = "aaaaa", needle = "bba" Output: -1
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("2 == " + strStr("hello", "ll"));
        System.out.println("-1 == " + strStr("aaaaa", "bba"));

        System.out.println("2 == " + strStrLite("hello", "ll"));
        System.out.println("-1 == " + strStrLite("aaaaa", "bba"));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
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

    private static int strStrLite(String haystack, String needle) {
        int h = haystack.length(), n = needle.length();
        if (h < n) return -1;
        if (n == 0) return 0;
        for (int i = 0; i < h - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) return i;
        }
        return -1;
    }

}
