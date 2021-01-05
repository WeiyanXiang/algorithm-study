package data.structure.queue;/**
 * @author Weiyan Xiang on 2021/1/4
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    static class Cell {
        int r;
        int c;
        int h;

        public Cell(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.h));
        queue.offer(new Cell(0, 0, 1));
        queue.offer(new Cell(0, 1, 2));
        queue.offer(new Cell(0, 2, 3));
        queue.offer(new Cell(1, 0, 0));
        queue.offer(new Cell(1, 1, 0));
        queue.offer(new Cell(1, 2, 4));
        queue.offer(new Cell(2, 0, 7));
        queue.offer(new Cell(2, 1, 6));
        queue.offer(new Cell(2, 2, 5));

        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
        System.out.print(queue.poll().h);
    }

}
