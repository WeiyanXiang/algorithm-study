package graph;/**
 * @author Weiyan Xiang on 2021/4/2
 */

import java.util.ArrayList;
import java.util.List;

public class FlowerPlantingWithNoAdj {
    /**
     * 1042. Flower Planting With No Adjacent
     * <p>
     * https://leetcode.com/problems/flower-planting-with-no-adjacent/
     * <p>
     * upvoted ans, the reason we can loop directly is because the question said it is guaranteed an answer exists.
     */
    public int[] gardenNoAdj(int n, int[][] paths) {
        // build adj graph 0-indexed based
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < paths.length; i++) {
            int a = paths[i][0] - 1;
            int b = paths[i][1] - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] res = new int[n]; // colors of each node index in graph
        for (int i = 0; i < n; i++) {
            int[] colors = new int[5]; // for each node, new a colors array to use index 1-5
            for (int next : graph[i]) {
                // mark used color for all current node's neighbors
                colors[res[next]] = 1;
            }
            // now color the available colors
            for (int c = 4; c >= 1; c--) {
                // if current color is available, mark res
                if (colors[c] != 1) {
                    res[i] = c;
                }
            }

        }
        return res;
    }
}
