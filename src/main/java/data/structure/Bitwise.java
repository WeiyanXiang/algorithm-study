package data.structure;

/**
 * @author Weiyan Xiang on 2021/12/7
 */

public class Bitwise {

    //普通操作
    void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }

    //位与操作
    void swapXor(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
    }

    int reverse(int a) {
        return ~a + 1;
    }

    int abs(int a) {
        int i = a >> 31;
        return i == 0 ? a : (~a + 1);
    }

    /**
     * 面的操作可以进行优化，可以将 i == 0 的条件判断语句去掉。我们都知道符号位 i 只有两种情况，即 i = 0 为正，i = -1 为负。 对于任何数与 0 异或都会保持不变，与 -1 即 0xffffffff
     * 进行异或就相当于对此数进行取反,因此可以将上面三目元算符转换为((a^i)-i)，即整数时 a 与 0 异或得到本身，再减去 0， 负数时与 0xffffffff 异或将 a 进行取反，然后在加上 1，即减去 i(i
     * =-1)
     */
    int abs2(int a) {
        int i = a >> 31;
        return ((a ^ i) - i);
    }

    int popcount(int a) {
        int count = 0;
        while (a != 0) {
            // get rid of right most digit of 1 each time
            a = a & (a - 1);
            count++;
        }
        return count;
    }

    int popcountXor(int a) {
        int count = 0;
        while (a != 0) {
            // pop out right most digit of 1 each time
            a = a ^ (a & -a);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Bitwise().popcount(-8));
        System.out.println(new Bitwise().popcountXor(-8));
        System.out.println(2 ^ 2);
    }

}
