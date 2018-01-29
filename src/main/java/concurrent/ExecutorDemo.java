/**
 * 
 */
package concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
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
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        RunnableImpl runnableTask = new RunnableImpl();
        CallalableImpl callalableTask = new CallalableImpl();

        executorService.execute(runnableTask);
        Future<?> submit1 = executorService.submit(runnableTask);
        Future<String> submit2 = executorService.submit(callalableTask);

        try {
            String invokeAnyReturnedValue = executorService.invokeAny(Arrays.asList(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("SECOND callable is invoked");
                    return "SECOND callable is invoked";
                }
            }, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("THIRD callable is invoked");
                    return "THIRD callable is invoked";
                }
            }, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("FOUR callable is invoked");
                    return "FOUR callable is invoked";
                }
            }));
            System.out.println("executorService.invokeAny method returns: " + invokeAnyReturnedValue);

            List<Future<String>> invokeAllFutures = executorService.invokeAll(Arrays.asList(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("SECOND callable is invoked");
                    return "5th callable is invoked";
                }
            }, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("THIRD callable is invoked");
                    return "6th callable is invoked";
                }
            }, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("FOUR callable is invoked");
                    return "7th callable is invoked";
                }
            }));
            invokeAllFutures.stream().forEach(eachFuture -> {
                try {
                    System.out.println("Each Future after invokeAll is: " + eachFuture.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });

            if (submit1.isDone()) {
                System.out.println("executor.submit(new RunnableImpl() is done and returned: " + submit1.get());
            }
            Thread.sleep(400);
            if (submit2.isDone()) {
                System.out.println("executor.submit(new CallalableImpl()) is done and returned: " + submit2.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
