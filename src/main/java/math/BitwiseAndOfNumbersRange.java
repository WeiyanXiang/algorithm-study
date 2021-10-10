package math;/**
 * @author Weiyan Xiang on 2021/10/10
 */

import java.util.*;

public class BitwiseAndOfNumbersRange {
    /**
     * 201. Bitwise AND of Numbers Range
     *
     * https://leetcode.com/problems/bitwise-and-of-numbers-range/
     *
     * ac ans: The hardest part of this problem is to find the regular pattern.
     * For example, for number 26 to 30
     * Their binary form are:
     * 11010
     * 11011
     * 11100　　
     * 11101　　
     * 11110
     *
     * Because we are trying to find bitwise AND, so if any bit there are at least one 0 and one 1, it always 0. In this
     * case, it is 11000.
     * So we are go to cut all these bit that they are different. In this case we cut the right 3 bit.
     *
     * I think after understand this, the code is trivial:
     */
    public int rangeBitwiseAnd(int left, int right) {
        int i=0; // i means we have how many bits are 0 on the right
        while(left!=right){
            left >>= 1;
            right >>= 1;
            i++;
        }
        return left<<i;
    }
}
