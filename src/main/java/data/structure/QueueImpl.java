package data.structure;

/**
 * @author Weiyan Xiang on 2020/3/24
 */
public class QueueImpl {
    private int head;
    private int tail;
    private String[] memory;
    private int size;

    public QueueImpl(int size) {
        this.head = 0;
        this.tail = -1;
        this.size = size;
        this.memory = new String[size];
    }

    public boolean enqueue(String item) {
        if (tail < size) {
            memory[++tail] = item;
            return true;
        }
        return false;
    }

    /**
     * Retrieves and removes the head of this queue
     *
     * @return
     */
    public String dequeue() {
        if (head >= 0) {
            return memory[head++];
        }
        return null;
    }

    public String peek() {
        return memory[head];
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl(10);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }
}
