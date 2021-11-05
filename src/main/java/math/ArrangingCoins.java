package math;

/**
 * @author Weiyan Xiang on 2021/11/5
 */

public class ArrangingCoins {
    /**
     * 441. Arranging Coins
     * <p>
     * https://leetcode.com/problems/arranging-coins/
     */
    public int arrangeCoins(int n) {
        int level = 1;
        while (n > 0) {
            level++;
            n -= level;
        }
        return level - 1;
    }
}
