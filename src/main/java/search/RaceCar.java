package search;/**
 * @author Weiyan Xiang on 2021/1/1
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RaceCar {
    /**
     * 818. Race Car
     * <p>
     * https://leetcode.com/problems/race-car/
     */
    public int racecar(int target) {
        Queue<SpdAndPo> queue = new LinkedList<>();
        // initial position
        queue.add(new SpdAndPo(0, 1));

        Set<SpdAndPo> visited = new HashSet<>();
        int depth = -1;
        while (!queue.isEmpty()) {
            depth++;
            for (int q = queue.size(); q > 0; q--) {
                SpdAndPo cur = queue.poll();
                int curPosition = cur.position;
                if (curPosition == target) return depth;
                if (visited.contains(cur)) continue;
                if (curPosition > 2 * target || curPosition < 0) continue;
                visited.add(cur);
                // explore both A and R and add that to queue and continue BFS
                // A
                queue.offer(new SpdAndPo(curPosition + cur.speed, cur.speed * 2));
                // R
                queue.offer(new SpdAndPo(curPosition, cur.speed > 0 ? -1 : 1));
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
