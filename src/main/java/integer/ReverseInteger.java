/**
 * 
 */
package integer;

/**
 * @author weiyan.xiang
 * @date 21 Jan 2018
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;
        String raw = String.valueOf(x);
        String rawAnswer = "";
        int i = raw.length() - 1;
        while (raw.charAt(i) == '0') {
            i--;
        }
        for (; i >= 0; i--) {
            if (raw.charAt(i) != '-') {
                rawAnswer += raw.charAt(i);
            } else {
                rawAnswer = "-".concat(rawAnswer);
            }
        }
        try {
            return Integer.parseInt(rawAnswer);
        } catch (Exception e) {
            return 0;
        }
    }
}
