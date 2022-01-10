package concepts.concurrent.aqs;/**
 * @author Weiyan Xiang on 2021/11/24
 */

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            int cur = i;
            executorService.submit(() -> {
                System.out.println("start " + cur);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end..");
        executorService.shutdown();
    }
}
