/**
 * 
 */
package dp;

/**
 * @author weiyan.xiang
 * @date 4 Mar 2018
 */
public class StairsCountTwo {

    public static int climbStairs(int n) {
        if (n <= 2)
            return n;
        int answer = 0, a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            answer = a + b;
            a = b;
            b = answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("89 == " + climbStairs(10));
    }
}
