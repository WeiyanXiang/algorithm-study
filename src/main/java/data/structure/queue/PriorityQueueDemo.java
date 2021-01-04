package data.structure.queue;/**
 * @author Weiyan Xiang on 2021/1/4
 */

import java.util.Objects;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

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

    public static void main(String[] args) {
        PriorityQueue<Cell> queue = new PriorityQueue<>();
        queue.offer(new Cell(1, 1, 4));
        queue.offer(new Cell(1, 1, 2));
        queue.offer(new Cell(1, 1, 3));
        queue.offer(new Cell(1, 1, 1));

        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
    }

}
