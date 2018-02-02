/**
 * 
 */
package dp;

/**
 * @author weiyan.xiang
 * @date 14 Jan 2018
 */
public class StairsCount {

    private static int[] cache = new int[11];
    private static int a = 1;
    private static int b = 2;
    private static int c = 3;

    /*
     * space complexity: O(n) time complexity: O(3^n) normal fib approach
     */
    public static int fibCount(int n) {
        if (n <= 3)
            return n;
        return fibCount(n - 1) + fibCount(n - 2) + fibCount(n - 3);
    }

    /*
     * use an array to cache already calculated countings
     * 
     * Space: O(n) Time: O(n)
     * 
     */
    private static int fibCacheCount(int n) {
        if (n == 0)
            return 0;
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 3;
        for (int i = 4; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];

        }
        return cache[n];

    }

    /*
     * use three parameters to store already calculated countings Space:
     * 
     * O(1) Time: O(n)
     */
    private static int fibParamCount(int n) {
        if (n == 0)
            return 0;
        int answer = 0, a = 1, b = 2, c = 3;
        for (int i = 4; i <= n; i++) {
            answer = a + b + c;
            a = b;
            b = c;
            c = answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(fibCount(10));
        System.out.println(fibParamCount(10));
        System.out.println(fibCacheCount(10));
    }
}
