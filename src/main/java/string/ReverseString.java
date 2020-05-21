/**
 *
 */
package string;

/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class ReverseString {

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
