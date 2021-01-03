package search;/**
 * @author Weiyan Xiang on 2021/1/1
 */

import java.util.*;

public class RaceCar {
    /**
     * 818. Race Car
     * <p>
     * https://leetcode.com/problems/race-car/
     * <p>
     * there are 2 DP solutions, below is the one easier to understand, ideas from huahua
     * https://zxi.mytechroad.com/blog/searching/leetcode-818-race-car/
     */
    private static int[][] m;

    public int racecarDp(int target) {
        if (m == null) {
            m = new int[10001][2];
            for (int t = 1; t <= 10000; t++) {
                // least steps to reach or exceed target position as per speed
                int n = (int) Math.ceil(Math.log(t + 1) / Math.log(2));
                // 0 is facing right, 1 is facing left
                if (1 << n == t + 1) {
                    m[t][0] = n;
                    m[t][1] = n + 1;
                    continue;
                }
                int l = (1 << n) - 1 - t;
                // now turn back
                // n 是到达target，n+1是掉一次头，Math.min（）部分是对于不同朝向的去最小值
                // 这些只是m[t][0]和m[t][1]的一个解，下面的for loop将会potentially优化
                m[t][0] = n + 1 + Math.min(m[l][1], m[l][0] + 1);
                m[t][1] = n + 1 + Math.min(m[l][0], m[l][1] + 1);
                // now loop to assume each i is turning/restart point, restart means reversing to achieve speed from 1
                for (int i = 1; i < t; i++) {
                    for (int d = 0; d <= 1; d++) {
                        m[t][d] = Math.min(m[t][d], Math.min(
                                // 方向正的（right）+2是因为掉2次头才可以
                                m[i][0] + 2 + m[t - i][d],
                                // 方向负的（left）+1是因为掉1次头就可以
                                m[i][1] + 1 + m[t - i][d]
                        ));
                    }
                }

            }
        }
        return Math.min(m[target][0], m[target][1]);
    }

    /**
     * BFS with pruning, time limits exceeded.
     * <p>
     * TC: O(2^D)
     * <p>
     * SC: O(2^D)
     * <p>
     * D is depth of the path
     */
    public int racecarMyVersion(int target) {
        Queue<SpdAndPo> queue = new LinkedList<>();
        // initial position
        queue.add(new SpdAndPo(0, 1));
        Set<String> visited = new HashSet<>(Arrays.asList("0_1", "0_-1"));

        int depth = -1;
        while (!queue.isEmpty()) {
            depth++;
            for (int q = queue.size(); q > 0; q--) {
                SpdAndPo cur = queue.poll();
                int curPosition = cur.position;
                int curSpeed = cur.speed;
                if (curPosition == target) return depth;
                // explore both A and R and add that to queue and continue BFS with pruning
                if (Math.abs(curSpeed) < 2 * target && Math.abs(curPosition) < 2 * target) {
                    // A
                    queue.offer(new SpdAndPo(curPosition + curSpeed, curSpeed * 2));
                }
                SpdAndPo newR = new SpdAndPo(curPosition, curSpeed > 0 ? -1 : 1);
                if (!visited.contains(newR.position + "_" + newR.speed)) {
                    // R
                    queue.offer(new SpdAndPo(curPosition, curSpeed > 0 ? -1 : 1));
                    visited.add(curPosition + "_" + curSpeed);
                }
            }
        }
        return -1;
    }

    class SpdAndPo {
        int position;
        int speed;

        SpdAndPo(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
}
