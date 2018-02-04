/**
 * 
 */
package dp;

/**
 * @author weiyan.xiang
 * @date 4 Feb 2018
 */
public class FibonacciDemo {

    public static int fibRecursice(int n) {
        return n <= 1 ? n : fibRecursice(n - 1) + fibRecursice(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("fibRecursice(18) => " + fibRecursice(18));
    }
}
