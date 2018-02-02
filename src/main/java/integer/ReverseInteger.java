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
            /**
             * here is a trick to avoid overflow
             */
            if ((newAnswer - tail) / 10 != answer)
                return 0;
            answer = newAnswer;
            x /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("reverse(-2147483412) -> == -2143847412  ? " + (reverse(-2147483412) == -2143847412));
        System.out.println("reverse(-2147483412) -> == -2143847412  ? " + (reverseInt(-2147483412) == -2143847412));
        System.out.println("reverse(5348239) -> == 9328435 ? " + (reverseInt(5348239) == 9328435));
    }

    public static int reverseInt(int x) {
        int answer = 0;
        while (x != 0) {
            int digit = x % 10;
            int newAnswer = digit + answer * 10;
            if ((newAnswer - digit) / 10 != answer) {
                return 0;
            }
            answer = newAnswer;
            x /= 10;
        }
        return answer;
    }

}
