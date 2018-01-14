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
    private static int fibCount(int length) {
        if (length == 0)
            return 0;
        if (length == 1)
            return 1;
        if (length == 2)
            return 2;
        if (length == 3)
            return 3;
        else
            return fibCount(length - 1) + fibCount(length - 2) + fibCount(length - 3);
    }

    /*
     * use an array to cache already calculated countings
     * 
     * Space: O(n) Time: O(n)
     * 
     */
    private static int fibCacheCount(int n) {
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 3;
        for (int i = 3; i <= n; i++) {
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
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 3;
        int answer = 0;
        for (int i = 3; i < n; i++) {
            answer = a + b + c;
            a = b;
            b = c;
            c = answer;
        }
        return answer;
    }
}
