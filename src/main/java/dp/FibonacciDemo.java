/**
 *
 */
package dp;

/**
 * @author weiyan.xiang
 * @date 4 Feb 2018
 */
public class FibonacciDemo {

    /**
     * Time: O(2^n)
     *
     * @param n
     * @return
     */
    public static int fibRecursice(int n) {
        return n <= 1 ? n : fibRecursice(n - 1) + fibRecursice(n - 2);
    }

    public static int fibOptimalDp(int n) {
        if (n < 2)
            return n;
        int c = 0, a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            b = a;
            a = c;
        }
        return a + b;
    }

    /**
     * Time: O(n), use an array to cache already done computations and hence increase performance
     *
     * @param n
     * @return
     */
    public static int fibBottomUpDp(int n) {
        if (n < 2)
            return n;
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    /**
     * Time: O(n)
     *
     * @param n
     * @return
     */
    public static int fibTopBottomDp(int n) {
        return doTopBottomFib(n, new int[n + 1]);
    }

    private static int doTopBottomFib(int n, int[] cache) {
        if (n < 2)
            return n;
        /**
         * cache the result to avoid repeated computing
         */
        cache[n] = cache[n - 1] + cache[n - 2];
        return doTopBottomFib(n - 1, cache) + doTopBottomFib(n - 2, cache);
    }

    public static int fibTwoVars(int n) {
        if (n < 2)
            return n;
        int a = 0;
        int b = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("fibRecursice(18) => " + fibRecursice(18));
        System.out.println("fibBottomUpDp(18) => " + fibBottomUpDp(18));
        System.out.println("fibTopBottomDp(18) => " + fibTopBottomDp(18));
        System.out.println("fibOptimalDp(18) => " + fibOptimalDp(18));
        System.out.println("fibTwoVars(18) => " + fibTwoVars(18));
    }
}
