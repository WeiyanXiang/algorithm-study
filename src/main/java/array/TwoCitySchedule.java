package array;

import java.util.Arrays;

/**
 * @author Weiyan Xiang on 2020/6/23
 */
public class TwoCitySchedule {
    /**
     * https://leetcode.com/problems/two-city-scheduling/discuss/667786/Java-or-C%2B%2B-or-Python3-or-With-detailed-explanation
     * <p>
     * EXPLANATION:- The problem is to send n persons to city A and n persons to city B with minimum cost.
     * <p>
     * The idea is to send each person to city A. costs = [[10,20],[30,200],[400,50],[30,20]]
     * <p>
     * So, totalCost = 10 + 30 + 400 + 30 = 470
     * <p>
     * Now, we need to send n persons to city B. Which persons do we need to send city B?
     * <p>
     * Here, we need to minimize the cost. We have already paid money to go to city A. So, Send the persons to city B
     * who get more refund so that our cost will be minimized.
     * <p>
     * So, maintain refunds of each person refund[i] = cost[i][1] - cost[i][0]
     * <p>
     * So, refunds of each person refund = [10, 170, -350, -10]
     * <p>
     * Here, refund +ve means we need to pay -ve means we will get refund.
     * <p>
     * So, sort the refund array.
     * <p>
     * refund = [-350, -10, 10, 170]
     * <p>
     * Now, get refund for N persons, totalCost += 470 + -350 + -10 = 110
     * <p>
     * So, minimum cost is 110
     */
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        int[] refunds = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            sum += costs[i][0];
            refunds[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refunds);
        for (int j = 0; j < refunds.length / 2; j++) {
            sum += refunds[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] costs = {
                {10, 20},
                {30, 200},
                {400, 50},
                {30, 20}
        };


        System.out.print(new TwoCitySchedule().twoCitySchedCost(costs));
    }

}
