/**
 *
 */
package string;


/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class ReverseString {

    public void reverseStringTwo(char[] c) {
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }

    public void reverseStringThree(char[] c) {
        int i = 0, j = c.length - 1;
        while (i < j) {
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }
    }

    public void reverseString(char[] s) {
        if (s == null || s.length < 2) return;
        int l = s.length;
        for (int i = 0; i < l / 2; i++) {
            char temp = s[i];
            s[i] = s[l - i - 1];
            s[l - i - 1] = temp;
        }
    }

    public static String reverse(String input) {
        int i = 0, j = input.length() - 1;
        char[] chars = input.toCharArray();
        char temp;
        while (i < j) {
            temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
        return String.valueOf(chars);
    }

    public static String reverseForLoop(String input) {
        char[] s = input.toCharArray();
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            int j = s.length - i - 1;
            s[i] = s[j];
            s[j] = tmp;
        }
        return String.valueOf(s);
    }


    public static void main(String[] args) {
        System.out.println("1 23 45 67 89 <- reverse ->" + reverse("1 23 45 67 89"));
        System.out.println("1 23 45 67 89 <- reverse ->" + reverseForLoop("1 23 45 67 89"));
    }
}
