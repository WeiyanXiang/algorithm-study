package array;/**
 * @author Weiyan Xiang on 2022/1/2
 */

import java.util.*;

public class TravelerFund {
    /**
     * For example:
     * <p>
     * Input: 3 //Array length 4 //Array elements start 2 -3
     * <p>
     * output: 0
     * <p>
     * A traveler is traveling form city of zeta to omega. He starts with X amount of money. Every day he spends some
     * money and also he may work on some days to earn money. He may find good work some day and end up earning more
     * than what he spends that day. It also may happen that he spends more than what he earns on any day. You are given
     * an array of integers which represents his net savings (earning -expense) on any day. You need to find out minimum
     * amount the traveler should begin with to ensure that he always have some money (>0) at the end of any day.
     * <p>
     * Explanation: Traveler saves $4 on first day, $2 on second day and $-3 on third day (expense is more on 3 day than
     * earnings). End of the first day, he has X + $4 End of the Second day, he has X + $(4+2) End of third day, he has
     * X + $(4+2-3)
     */
    public int startWithFund(int[] netSaves) {
        int sum = 0, start = 0;
        for (int net : netSaves) {
            sum += net;
            if (sum < 0) start = Math.max(Math.abs(sum), start);
        }
        return start;
    }

}
