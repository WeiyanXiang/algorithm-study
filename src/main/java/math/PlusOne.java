package math;

/**
 * @author Weiyan Xiang on 2020/5/21
 */

/**
 * https://leetcode.com/problems/plus-one/submissions/
 */
public class PlusOne {

    public int[] plusOne(int[] d) {
        int n = d.length;
        for (int i = n - 1; i >= 0; i--) {
            if (d[i] + 1 < 10) {
                d[i]++;
                return d;
            }
            d[i] = 0;
        }
        int[] nd = new int[n + 1];
        nd[0] = 1;
        return nd;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {4, 3, 9, 9};
        for (int e : plusOne.plusOne(digits)) {
            System.out.print(e + " ");
        }
    }


}
