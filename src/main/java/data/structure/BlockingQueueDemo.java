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

    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
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
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(runnable);

        System.out.println("Below is to poll from blocking queue");
        System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
        System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
        System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
        System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
        System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));

        Thread t1 = new Thread(runnable);
        t1.start();
        System.out.println("Below is to poll from blocking queue");
        System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
        System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
        System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
        System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));
        System.out.println(queue.poll(200, TimeUnit.MILLISECONDS));

    }

}
