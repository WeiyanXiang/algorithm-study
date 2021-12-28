package math;/**
 * @author Weiyan Xiang on 2021/12/26
 */

import java.util.*;

public class EliminationGame {
    /**
     * 390. Elimination Game
     * <p>
     * https://leetcode.com/problems/elimination-game/
     * <p>
     * upvoted ans: math question
     *
     * Denote L as traversing [1,...,n] from left to right, R as traversing [1,...,n] from right to left.
     *
     * When n is odd:
     * L(1234567) = R(246) = R(123)*2
     * R(1234567) = L(246) = L(123)*2
     *
     * When n is even:
     * L(123456) = R(246) = R(123)*2
     * R(123456) = L(135) = L(123)*2 - 1
     */
    public int lastRemaining(int n) {
        return leftToRight(n);
    }

    private static int leftToRight(int n) {
        if (n <= 2) return n;
        return 2 * rightToLeft(n / 2);
    }

    private static int rightToLeft(int n) {
        if (n <= 2) return 1;
        if (n % 2 == 1) return 2 * leftToRight(n / 2);
        return 2 * leftToRight(n / 2) - 1;
    }

    //@formatter:off
    /**
     *  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
     *
     * Let us start with head = 1, left = true, step = 1 (times 2 each turn), remaining = n(24)
     *
     * we first move from left, we definitely need to move head to next position. (head = head + step)
     * So after first loop we will have:
     * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 - > 2 4 6 8 10 12 14 16 18 20 22 24
     * head = 2, left = false, step = 1 * 2 = 2, remaining = remaining / 2 = 12
     *
     * second loop, we move from right, in what situation we need to move head?
     * only if the remaining % 2 == 1, in this case we have 12 % 2 == 0, we don't touch head.
     * so after this second loop we will have:
     * 2 4 6 8 10 12 14 16 18 20 22 24 - > 2 6 10 14 18 22
     * head = 2, left = true, step = 2 * 2 = 4, remaining = remaining / 2 = 6
     *
     * third loop, we move from left, move head to next position
     * after third loop we will have:
     * 2 6 10 14 18 22 - > 6 14 22
     * head = 6, left = false, step = 4 * 2 = 8, remaining = remaining / 2 = 3
     *
     * fourth loop, we move from right, NOTICE HERE:
     * we have remaining(3) % 2 == 1, so we know we need to move head to next position
     * after this loop, we will have
     * 6 14 22 - > 14
     * head = 14, left = true, step = 8 * 2 = 16, remaining = remaining / 2 = 1
     *
     * while loop end, return head
     */
    //@formatter:on
    public int lastRemainingAnother(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1, head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) head += step;
            step *= 2;
            remaining /= 2;
            left = !left;
        }
        return head;
    }
}
