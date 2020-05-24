package math;

/**
 * @author Weiyan Xiang on 2020/5/23
 */
public class IsPowOfTwo {
    public boolean isPowerOfTwo(int n) {
        // because pow of 2 in binary will always be: 100000...
        return n > 0 && n == (n & n - 1);
    }
}
