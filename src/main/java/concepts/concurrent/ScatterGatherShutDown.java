package concepts.concurrent;/**
 * @author Weiyan Xiang on 2022/1/25
 */

import java.util.List;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

public class ScatterGatherShutDown {
    ExecutorService pool = Executors.newFixedThreadPool(5);
    ExecutorCompletionService completionService = new ExecutorCompletionService(pool);


    //1.Normal scatter-gather
    public void executeTasks(List<Callable<String>> tasks) {
        List<Future<String>> futures = tasks.stream().map(t -> pool.submit(t)).collect(toList());
        try {
            for (Future<String> fut : futures) fut.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    //2.better Normal scatter-gather
    public void executeTasksAll(List<Callable<String>> tasks) {
        try {
            List<Future<String>> futures = pool.invokeAll(tasks);
            for (Future<String> f : futures) {
                f.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }
    }

    //3. Using CompletionService:  this is faster than above over all time
    public void executeTasksCmpl(List<Callable<String>> tasks) {
        try {
            tasks.forEach(fut -> completionService.submit(fut));
            for (int i = 0; i < tasks.size(); i++) {
                completionService.take().get();
                // do sth, take like 2 sec
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }
    }

    //4. Shutdown
    public void shutdownPool() {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                pool.shutdownNow();
                if (pool.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                    // something goes wrong pool can not stopped
                }
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
