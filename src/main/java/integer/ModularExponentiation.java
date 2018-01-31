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

    public static void main(String[] args) {
        System.out.println("Input:  x = 2, y = 3, p = 5, Output: 3 = " + computeModularExponentiation(2, 3, 5));
        System.out.println("Input:  x = 2, y = 5, p = 13, Output: 6 = " + computeModularExponentiation(2, 5, 13));
    }
}
