/**
 * 
 */
package string;

/**
 * @author weiyan.xiang
 * @date 1 Mar 2018
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        int intA = Integer.parseInt(a);
        int intB = Integer.parseInt(b);

        int raw = intA + intB;

        return toBinary(raw).toString();
    }

    private static int toBinary(int input) {
        int n = input;
        int answer = 1;
        while (n > 0) {
            answer += n % 2;
            answer *= 10;
        }
        return null;
    }

    public static void main(String[] args) {
        addBinary("11", "1");
    }

}
