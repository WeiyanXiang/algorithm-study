/**
 * 
 */
package data.structure;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author weiyan.xiang
 * @date 15 Feb 2018
 */
public class BlockingQueueDemo {

    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);

    public static void blockingQueueDemo() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
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

                }
            };
            executor.submit(runnable);

            System.out.println("Below is to poll from blocking queue");
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));

            executor.submit(runnable);
            System.out.println("Below is to poll from blocking queue");
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
