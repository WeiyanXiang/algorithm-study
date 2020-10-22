/**
 *
 */
package data.structure.queue;

import java.util.concurrent.*;

/**
 * @author weiyan.xiang
 * @date 15 Feb 2018
 */
public class BlockingQueueDemo {

    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);

    /**
     * BQ is based on queue and sync both enqueue and dequeue method to achieve thread-safe, the internal queue should
     * also be volatile to ensure data visibility
     */
    public static void blockingQueueDemo() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    queue.add(1);
                    queue.add(1);
                    queue.add(1);
                    queue.add(1);
                    queue.add(1);
                    queue.add(1);
                    queue.add(1);
                    queue.add(1);
                    queue.add(1);
                    queue.add(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            };
            executor.submit(runnable);

            System.out.println("Below is to dequeue from blocking queue");
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));

            executor.submit(runnable);
            System.out.println("Below is to dequeue from blocking queue");
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        blockingQueueDemo();
    }

}
