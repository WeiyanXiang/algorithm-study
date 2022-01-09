/**
 *
 */
package concepts.concurrent;

import java.util.Arrays;
import java.util.List;
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
        try {
            RunnableImpl runnableTask = new RunnableImpl();
            CallableImpl callalableTask = new CallableImpl();

            System.out.println("below is submit and execute demo ==> \n");
            submitAndExecuteDemo(executorService, runnableTask, callalableTask);
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("below is invokeAny demo ==> \n");
            invokeAnyDemo(executorService);
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("below is invokeAll demo ==> \n");
            invokeAllDemo(executorService);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private void waysToCreateExecutor() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        Thread thread = new Thread(new RunnableImpl());
        // thread.setDaemon(true);
        // 对静态方法 Thread.yield() 的调用声明了当前线程已经完成了生命周期中最重要的部分，可以切换给其它线程来执行。
        // 该方法只是对线程调度器的一个建议，而且也只是建议具有相同优先级的其它线程可以运行。
        Thread.yield();
    }

    private static void submitAndExecuteDemo(ExecutorService executorService, RunnableImpl runnableTask,
                                             CallableImpl callalableTask) {
        executorService.execute(runnableTask);
        Future<?> submit1 = executorService.submit(runnableTask);
        Future<String> submit2 = executorService.submit(callalableTask);

        System.out.println("executor.submit(new RunnableImpl() is done? " + submit1.isDone());
        System.out.println("executor.submit(new CallalableImpl()) is done ? " + submit2.isDone());
    }

    private static void invokeAllDemo(ExecutorService executorService) throws InterruptedException {
        List<Future<String>> invokeAllFutures = executorService.invokeAll(Arrays.asList(
                () -> {
                    System.out.println("5th callable is invoked");
                    return "5th callable is invoked";
                },
                () -> {
                    System.out.println("6th callable is invoked");
                    return "6th callable is invoked";
                },
                () -> {
                    System.out.println("7th callable is invoked");
                    return "7th callable is invoked";
                }));
        invokeAllFutures.stream().forEach(eachFuture -> {
            try {
                System.out.println("Each Future after invokeAll is: " + eachFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static void invokeAnyDemo(ExecutorService executorService) throws InterruptedException, ExecutionException {
        String invokeAnyReturnedValue = executorService.invokeAny(Arrays.asList(
                () -> {
                    System.out.println("2nd callable is invoked");
                    return "2nd callable is invoked";
                },
                () -> {
                    System.out.println("3rd callable is invoked");
                    return "3rd callable is invoked";
                },
                () -> {
                    System.out.println("4th callable is invoked");
                    return "4th callable is invoked";
                })
        );
        System.out.println("executorService.invokeAny method returns: " + invokeAnyReturnedValue);
    }
}
