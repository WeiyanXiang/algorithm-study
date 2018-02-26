/**
 * 
 */
package string;

/**
 * @author weiyan.xiang
 * @date 26 Feb 2018
 */
public class CountAndSay {

    /*
     * Base case: n = 0 print "1" for n = 1, look at previous string and write
     * number of times a digit is seen and the digit itself. In this case, digit
     * 1 is seen 1 time in a row... so print "1 1" for n = 2, digit 1 is seen
     * two times in a row, so print "2 1" for n = 3, digit 2 is seen 1 time and
     * then digit 1 is seen 1 so print "1 2 1 1" for n = 4 you will print
     * "1 1 1 2 2 1"
     * 
     * 1. 1
     * 
     * 2. 11
     * 
     * 3. 21
     * 
     * 4. 1211
     * 
     * 5. 111221
     * 
     */
    public static String count(int n) {
        if (n == 1)
            return "1";
        else {
            String answer = "";
            String prev = count(n - 1);
            int i = 0;
            while (i < prev.length()) {
                int subCount = 1;
                while (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                    i++;
                    subCount++;
                }
                answer += subCount + "" + prev.charAt(i);
                i++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(count(10));
    }

}
