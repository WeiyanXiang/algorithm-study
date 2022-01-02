package array;/**
 * @author Weiyan Xiang on 2022/1/2
 */

import java.util.*;

public class GasStation {
    /**
     * 134. Gas Station
     * <p>
     * https://leetcode.com/problems/gas-station/
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int tank = 0;
        int sum = 0;
        for (int j = 0; j < gas.length; j++) {
            sum += gas[j] - cost[j];
            tank += gas[j] - cost[j];
            // when tank < 0, it is impossible to be start point, reset it
            if (tank < 0) {
                start = j + 1;
                tank = 0;
            }
        }
        if (sum < 0) return -1;
        return start;
    }
}
