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
     * For example, a = "11" b = "1"
     * 
     * Return "100".
     * 
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0)
                sum += b.charAt(j--) - '0'; // formatting digit to int
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("100 == " + addBinary("11", "1"));

        System.out.println('1' - '0');
        System.out.println('0' - '0');
    }

}
