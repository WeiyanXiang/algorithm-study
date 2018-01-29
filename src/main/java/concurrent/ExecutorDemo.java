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
        try {
            RunnableImpl runnableTask = new RunnableImpl();
            CallalableImpl callalableTask = new CallalableImpl();

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

    private static void submitAndExecuteDemo(ExecutorService executorService, RunnableImpl runnableTask,
            CallalableImpl callalableTask) throws InterruptedException, ExecutionException {
        executorService.execute(runnableTask);
        Future<?> submit1 = executorService.submit(runnableTask);
        Future<String> submit2 = executorService.submit(callalableTask);

        System.out.println("executor.submit(new RunnableImpl() is done? " + submit1.isDone());
        System.out.println("executor.submit(new CallalableImpl()) is done ? " + submit2.isDone());
    }

    private static void invokeAllDemo(ExecutorService executorService) throws InterruptedException {
        List<Future<String>> invokeAllFutures = executorService.invokeAll(Arrays.asList(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("5th callable is invoked");
                return "5th callable is invoked";
            }
        }, new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("6th callable is invoked");
                return "6th callable is invoked";
            }
        }, new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("7th callable is invoked");
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
    }

    private static void invokeAnyDemo(ExecutorService executorService) throws InterruptedException, ExecutionException {
        String invokeAnyReturnedValue = executorService.invokeAny(Arrays.asList(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("2nd callable is invoked");
                return "2nd callable is invoked";
            }
        }, new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("3rd callable is invoked");
                return "3rd callable is invoked";
            }
        }, new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("4th callable is invoked");
                return "4th callable is invoked";
            }
        }));
        System.out.println("executorService.invokeAny method returns: " + invokeAnyReturnedValue);
    }
}
