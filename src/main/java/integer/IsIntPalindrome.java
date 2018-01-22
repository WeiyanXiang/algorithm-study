/**
 * 
 */
package integer;

/**
 * @author weiyan.xiang
 * @date 22 Jan 2018
 */
public class IsIntPalindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String raw = String.valueOf(x);
        int n = raw.length();
        for (int i = 0; i <= n / 2; i++) {
            if (raw.charAt(i) != raw.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("isPalindrome(-2147483648) == false ? " + isPalindrome(-2147483648));
    }
}
