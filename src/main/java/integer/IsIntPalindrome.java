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

    /**
     * optimal method: compare half of the digits in x, so don’t need to deal
     * with overflow.
     * 
     * @param x
     * @return
     */
    public static boolean isPalindromeNoMemory(int x) {
        if (x < 0 || x != 0 && x % 10 == 0)
            return false;
        int rev = 0;
        while (rev < x) {
            rev = x % 10 + rev * 10;
            x /= 10;
        }
        return rev == x || rev / 10 == x;
    }

    public static void main(String[] args) {
        System.out.println("isPalindrome(1234321) == true ? " + isPalindromeNoMemory(1234321));
        System.out.println("isPalindrome(123321) == true ? " + isPalindromeNoMemory(123321));
        System.out.println("isPalindrome(-2147483648) == false ? " + isPalindrome(-2147483648));
        System.out.println("isPalindrome(-2147483648) == false ? " + isPalindromeNoMemory(-2147483648));
    }

}
