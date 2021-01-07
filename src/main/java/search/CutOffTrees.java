package search;/**
 * @author Weiyan Xiang on 2021/1/4
 */

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTrees {

    class Cell {
        int r;
        int c;
        int h;

        public Cell(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }

    }

    /**
     * 675. Cut Off Trees for Golf Event
     * <p>
     * https://leetcode.com/problems/cut-off-trees-for-golf-event/submissions/
     *
     * my own version with created object after learning from huahua ans
     */
    public int cutOffTree(List<List<Integer>> forest) {
        // priority queue to keep tracks of sorted tree's location
        // BFS to work out the distances in total
        int m = forest.size();
        int n = forest.get(0).size();
        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.h - b.h);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h > 1) queue.add(new Cell(i, j, h));
            }
        }
        int steps = 0;
        Cell prev = new Cell(0, 0, 0);
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            int curStep = bfsShortestPath(prev, cur, forest);
            if (curStep == Integer.MAX_VALUE) return -1;
            steps += curStep;
            prev = cur;
        }
        return steps;
    }

    private int bfsShortestPath(Cell start, Cell end, List<List<Integer>> forest) {

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start.r, start.c});
        int steps = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int qs = 0; qs < qSize; qs++) {
                int[] poll = queue.poll();
                if (poll[0] == end.r && poll[1] == end.c) return steps;
                for (int[] d : dirs) {
                    int newR = poll[0] + d[0];
                    int newC = poll[1] + d[1];
                    if (newR < 0 || newR >= m || newC < 0 || newC >= n) continue;
                    if (visited[newR][newC] != 0) continue;
                    if (forest.get(newR).get(newC) == 0) continue;
                    visited[newR][newC] = 1;
                    queue.offer(new int[]{newR, newC});

                }
            }
            steps++;
        }
        return Integer.MAX_VALUE;
    }
}
