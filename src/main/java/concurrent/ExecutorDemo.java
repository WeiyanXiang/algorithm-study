/**
 * 
 */
package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author weiyan.xiang
 * @date 28 Jan 2018
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<?> submit1 = executor.submit(new RunnableImpl());
        Future<String> submit2 = executor.submit(new CallalableImpl());
        executor.execute(new RunnableImpl());

        try {
            if (submit1.isDone()) {
                System.out.println("executor.submit(new RunnableImpl() is done and returned: " + submit1.get());
            }
            Thread.sleep(100);
            if (submit2.isDone()) {
                System.out.println("executor.submit(new CallalableImpl()) is done and returned: " + submit2.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
