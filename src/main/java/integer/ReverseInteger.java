/**
 * 
 */
package integer;

/**
 * @author weiyan.xiang
 * @date 21 Jan 2018
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int answer = 0;
        while (x != 0) {
            int tail = x % 10;
            int newAnswer = answer * 10 + tail;
            if ((newAnswer - tail) / 10 != answer)
                return 0;
            answer = newAnswer;
            x /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("reverse(-2147483412) -> == -2143847412  ? " + (reverse(-2147483412) == -2143847412));
    }

}
