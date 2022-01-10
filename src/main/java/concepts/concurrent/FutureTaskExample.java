package concepts.concurrent;/**
 * @author Weiyan Xiang on 2022/1/10
 */

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            int result = 0;
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                result = i;
                System.out.println("running future task with result:" + result);
            }
            return result;
        });
        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        Thread otherThread = new Thread(() -> {
            System.out.println("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
    }
}
