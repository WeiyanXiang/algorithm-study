/**
 * 
 */
package integer;

/**
 * @author weiyan.xiang
 * @date 31 Jan 2018
 */
public class ModularExponentiation {

    /*
     * Given three numbers x, y and p, compute (xy) % p
     * 
     * this have risk to overflow the int quickly
     */
    public static int computeModularExponentiation(int x, int y, int p) {
        int count = 0;
        int answer = 1;
        while (count < y) {
            answer *= x;
            count++;
        }
        return answer % p;
    }

    /**
     * (x * y) mod p = ( (x mod p)*(y mod p) ) mod p
     * 
     * @param x
     * @param y
     * @param p
     * @return
     */
    public static int computeModularExponentiationOptimal(int x, int y, int p) {
        int res = 1;

        x = x % p; // Update x if it is more than or
                   // equal to p

        while (y > 0) {
            // If y is odd, multiply x with result
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }
            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Input:  x = 2, y = 3, p = 5, Output: 3 = " + computeModularExponentiation(2, 3, 5));
        System.out.println("Input:  x = 2, y = 5, p = 13, Output: 6 = " + computeModularExponentiation(2, 5, 13));
        System.out.println("Input:  x = 2, y = 3, p = 5, Output: 3 = " + computeModularExponentiationOptimal(2, 3, 5));
        System.out
                .println("Input:  x = 2, y = 5, p = 13, Output: 6 = " + computeModularExponentiationOptimal(2, 5, 13));
    }
}
