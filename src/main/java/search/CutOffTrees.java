package search;/**
 * @author Weiyan Xiang on 2021/1/4
 */

import java.util.*;

public class CutOffTrees {

    static class Cell implements Comparable {
        int r;
        int c;
        int h;

        public Cell(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return h == cell.h;
        }

        @Override
        public int hashCode() {
            return Objects.hash(h);
        }

        @Override
        public int compareTo(Object o) {
            return this.h - ((Cell) o).h;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        // priority queue to keep tracks of sorted tree's location
        // BFS to work out the distances in total
        PriorityQueue<Cell> queue = new PriorityQueue<>();
        int m = forest.size();
        int n = forest.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h != 0) queue.add(new Cell(i, j, h));
            }
        }
        int steps = 0;
        Cell prev = queue.poll();
        steps += bfsShortestPath(new Cell(0, 0, 1), prev, forest);
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            int curStep = bfsShortestPath(prev, cur, forest);
            if (curStep == Integer.MAX_VALUE) return -1;
            steps += curStep;
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
            int[] poll = queue.poll();
            for (int[] d : dirs) {
                int newR = poll[0] + d[0];
                int newC = poll[1] + d[1];
                if (newR == end.r && newC == end.c) return steps + 1;
                if (newR < 0 || newR >= m || newC < 0 || newC >= n) continue;
                if (visited[newR][newC] != 0) continue;
                if (forest.get(newR).get(newC) == 0) continue;
                visited[newR][newC] = 1;
                queue.offer(new int[]{newR, newC});

            }
            steps++;
        }
        return Integer.MAX_VALUE;
    }
}
