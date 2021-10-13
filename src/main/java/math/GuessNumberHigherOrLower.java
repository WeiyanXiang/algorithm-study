package math;

/**
 * @author Weiyan Xiang on 2021/10/13
 */

public class GuessNumberHigherOrLower {

    /**
     * 374. Guess Number Higher or Lower
     *
     * https://leetcode.com/problems/guess-number-higher-or-lower/
     *
     *
     */

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number 1 if num is higher than the guess number otherwise return 0 int
     * guess(int num);
     */


    public int guessNumber(int n) {
        int l = 1, r = n;
        int mid = l + (r - l) / 2;
        while (l < r) {
            if (guess(mid) == 0) return mid;
            if (guess(mid) == -1) {
                r = mid;
            } else if (guess(mid) == 1) {
                l = mid + 1;
            }
            mid = l + (r - l) / 2;
        }
        return l;
    }

    int guess(int num) {
        return 0;
    }

}
