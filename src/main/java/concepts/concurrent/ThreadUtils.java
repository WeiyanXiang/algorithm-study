/**
 * 
 */
package concepts.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author weiyan.xiang
 * @date 18 Feb 2018
 */
public class ThreadUtils {

    ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.AbortPolicy());

    ExecutorService scheduledService = Executors.newScheduledThreadPool(5);
    ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    ExecutorCompletionService completionService = new ExecutorCompletionService(Executors.newSingleThreadExecutor());

    public static List<Thread> getThreads(int number, Runnable runnable) {
        int i = 0;
        List<Thread> answer = new ArrayList<>();
        while (i < number) {
            answer.add(new Thread(runnable));
            i++;
        }
        return answer;
    }

    public static void startAll(List<Thread> threads) {
        threads.forEach(t -> t.start());
    }

}
