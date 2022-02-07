package concepts.concurrent;/**
 * @author Weiyan Xiang on 2022/1/10
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    public static void main(String[] args) throws Exception {
        // create two object of MyRunnable class
        // for FutureTask and sleep 1000, 2000
        // millisecond before checking again
        MyRunnable r1 = new MyRunnable(1000);
        MyRunnable r2 = new MyRunnable(2000);

        FutureTask<String> futureTask1 = new FutureTask<>(r1, "FutureTask1 is complete");
        FutureTask<String> futureTask2 = new FutureTask<>(r2, "FutureTask2 is complete");

        // create thread pool of 2 size for ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // submit futureTask1 to ExecutorService
        executor.submit(futureTask1);

        // submit futureTask2 to ExecutorService
        executor.submit(futureTask2);
    }

    static class MyRunnable implements Runnable {

        private int num;

        public MyRunnable(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread is running with sleeping: " + num + " ms");
        }
    }
}
