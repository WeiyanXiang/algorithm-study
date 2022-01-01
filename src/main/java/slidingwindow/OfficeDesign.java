package slidingwindow;/**
 * @author Weiyan Xiang on 2022/1/1
 */

import java.util.*;

public class OfficeDesign {
    //@formatter:off
    /**
     * Example
     * prices = [2,3,5, 1, 1, 2, 1]
     * money = 7
     * All subarrays that sum to less than or equal to 7:
     * Length 1 subarrays are [2],[3],[5],[1],[1], [2],[1 ]
     * Length 2 - [2,3], [5, 1], [1, 1], [1, 2], [2, 1]
     * Length 3 - [5. 1. 1],[1, 1, 2],[1,2,1]
     * Length 4 - [1, 1, 2, 1]
     * The longest of these, or the maximum number of colors that can be purchased, is 4.
     * Function Description
     * Complete the function getMaxColors in the editor below.
     * getMaxColors has the following parameters:
     * int prices[n]: the prices of the various paint colors
     * int money: the amount of money the company can spend on paints
     * Returns: int the maximum number of colors the company can purchase
     */
    //@formatter:on
    public int getMaxColors(int[] prices, int money) {
        int l = 0, r = 0;
        int sum = 0, max = 0;
        while (r < prices.length) {
            sum += prices[r];
            while (sum > money) {
                sum -= prices[l];
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

}
