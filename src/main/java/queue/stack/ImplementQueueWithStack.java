/**
 * 
 */
package queue.stack;

import java.util.Stack;

/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class ImplementQueueWithStack {
    private Stack<String> s1 = new Stack<>();
    private Stack<String> s2 = new Stack<>();

    /**
     * dequeue
     * 
     * @return
     */
    public String poll() {
        if (!s1.isEmpty())
            return s1.pop();
        return null;
    }

    public String peek() {
        if (!s1.isEmpty())
            return s1.peek();
        return null;
    }

    /**
     * enqueue, make it costly and make dequeue quick
     */
    public void add(String element) {
        // move all from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        // push all from s2 to s1
        s1.push(element);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public static void main(String[] args) {
        ImplementQueueWithStack queue = new ImplementQueueWithStack();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
