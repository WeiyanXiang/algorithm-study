/**
 * 
 */
package string;

/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class ReverseAStringWithoutSpecial {

    public static String reverse(String s) {
        char[] ss = s.toCharArray();
        int i = 0, j = ss.length - 1;
        char temp;
        while (i < j) {
            if (!isLetter(ss[i])) {
                i++;
            }
            if (!isLetter(ss[j])) {
                j--;
            } else {
                temp = ss[i];
                ss[i] = ss[j];
                ss[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(ss);
    }

    private static boolean isLetter(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
        String input = "Ab,c,de!$";
        System.out.println("reverse without special chars for: Ab,c,de!$ -> " + reverse(input));

    }

}
