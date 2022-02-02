/**
 *
 */
package concepts.concurrent;

import java.util.concurrent.*;

/**
 * @author weiyan.xiang
 * @date 28 Jan 2018
 */
public class ExecutorDemo {
    ExecutorService pool = Executors.newFixedThreadPool(5);
    ExecutorService cachedPool = Executors.newCachedThreadPool();
    ExecutorService singlePool = Executors.newSingleThreadExecutor();
    ExecutorService scheduledPool = Executors.newScheduledThreadPool(5);
    ExecutorService scheculedPool2 = Executors.newSingleThreadScheduledExecutor();
    
    ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    ForkJoinPool forkJoinPool2 = new ForkJoinPool(5);
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
            10,
            6000,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            new ThreadPoolExecutor.DiscardOldestPolicy());
}
