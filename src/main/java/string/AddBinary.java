/**
 * 
 */
package string;

/**
 * @author weiyan.xiang
 * @date 1 Mar 2018
 */
public class AddBinary {
    /**
     * Given two binary strings, return their sum (also a binary string).
     * 
     * For example,
     * 
     * a = "11"
     * 
     * b = "1"
     * 
     * Return "100".
     * 
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int intA = Integer.parseInt(a);
        int intB = Integer.parseInt(b);

        String answer = "";
        char digitForNext = '0';
        for (int i = Math.max(a.length() - 1, b.length()); i >= 0; i--) {
            if (i < b.length()) {
                if (digitForNext == '0') {
                    if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                        answer += '0';
                        digitForNext = '1';
                    } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                        answer += '0';
                        digitForNext = '0';
                    } else if (a.charAt(i) == '1' && b.charAt(i) == '0') {
                        answer += '1';
                        digitForNext = '0';
                    } else if (a.charAt(i) == '0' && b.charAt(i) == '1') {
                        answer += '1';
                        digitForNext = '0';
                    }
                } else {
                    if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                        answer += '1';
                        digitForNext = '1';
                    } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                        answer += '1';
                        digitForNext = '0';
                    } else if (a.charAt(i) == '1' && b.charAt(i) == '0') {
                        answer += '0';
                        digitForNext = '1';
                    } else if (a.charAt(i) == '0' && b.charAt(i) == '1') {
                        answer += '0';
                        digitForNext = '1';
                    }
                }
            } else {
                answer += a.charAt(i);
            }
        }
        return answer;
    }

    private static int toBinary(int input) {
        int n = input;
        int answer = 1;
        while (n > 0) {
            answer += n % 2;
            answer *= 10;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("100 == " + addBinary("11", "1"));
    }

}
