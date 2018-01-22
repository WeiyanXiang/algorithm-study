/**
 * 
 */
package integer;

/**
 * @author weiyan.xiang
 * @date 22 Jan 2018
 */
public class IsIntPalindrome {

    /**
     * using a additional string
     * 
     * @param x
     * @return
     */
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

    public static boolean isPalindromeNoMemory(int x) {
        if (x < 0)
            return false;
        if (x != 0 && x % 10 == 0)
            return true;

        int rev = 0;
        while (rev < x) {
            rev = x % 10 + rev * 10;
            x /= 10;
        }
        return rev / 10 == x || rev == x;
    }

    public static void main(String[] args) {
        System.out.println("isPalindrome(-2147483648) == false ? " + isPalindrome(-2147483648));
        System.out.println("isPalindrome(-2147483648) == false ? " + isPalindromeNoMemory(-2147483648));
    }
}
