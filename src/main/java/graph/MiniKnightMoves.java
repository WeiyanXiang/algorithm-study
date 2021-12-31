package graph;/**
 * @author Weiyan Xiang on 2021/12/30
 */

import java.util.*;

public class MiniKnightMoves {

    /**
     * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
     * <p>
     * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal
     * direction, then one square in an orthogonal direction.
     * <p>
     * Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer
     * exists.
     * <p>
     * Example 1: Input: x = 2, y = 1 Output: 1 Explanation: [0, 0] → [2, 1]
     * <p>
     * Example 2: Input: x = 5, y = 5 Output: 4 Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
     * <p>
     * Constraints: |x| + |y| <= 300
     */

    /**
     * BFS template ans
     */
    public int minKnightMoves(int x, int y) {
        int[][] directions = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int[] startPoint = {0, 0};
        queue.add(startPoint);
        int count = 0;
        Set<int[]> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int j = 0; j < qSize; j++) {
                int[] cur = queue.poll();
                if (cur[0] == x && cur[1] == y) return count;
                if (visited.contains(cur)) continue;
                visited.add(cur);
                for (int i = 0; i < directions.length; i++) {
                    queue.add(new int[]{cur[0] + directions[i][0], cur[1] + directions[i][1]});
                }
            }
            count++;
        }
        return -1;
    }

}