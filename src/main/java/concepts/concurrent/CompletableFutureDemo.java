package concepts.concurrent;/**
 * @author Weiyan Xiang on 2022/2/9
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        // running task in ForkJoin.commonPool()
        CompletableFuture.runAsync(() -> System.out.println("runnerable 1"));
        // supply with executor
        CompletableFuture.runAsync(() -> System.out.println("runnerable 1"), Executors.newSingleThreadExecutor());
        CompletableFuture.supplyAsync(() -> "runnable 2");
        CompletableFuture.supplyAsync(() -> "runnable 2", Executors.newSingleThreadExecutor());
    }
}
