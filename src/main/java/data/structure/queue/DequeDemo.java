package data.structure.queue;/**
 * @author Weiyan Xiang on 2021/11/14
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        // stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        // queue
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.addLast(2);
        queue.addLast(3);

        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());


    }
}
