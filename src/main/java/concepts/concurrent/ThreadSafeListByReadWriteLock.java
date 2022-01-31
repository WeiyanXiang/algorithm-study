/**
 *
 */
package concepts.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author weiyan.xiang
 * @date 11 Feb 2018
 */
public class ThreadSafeListByReadWriteLock<E> {

    /**
     * thread-safe array list
     */
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    private final List<E> list = new ArrayList<>();

    public void add(E o) throws InterruptedException {
        /**
         * Acquires the lock only if it is free at the time of invocation.
         */
        if (writeLock.tryLock()) {
            Thread.sleep(5000);
            try {
                list.add(o);
                System.out.println("writing element by thread: " + Thread.currentThread().getName());
            } finally {
                writeLock.unlock();
            }
        }
    }

    public E get(int i) {
        readLock.lock();
        try {
            System.out.println("reading elements by thread: " + Thread.currentThread().getName());
            return list.get(i);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            ThreadSafeListByReadWriteLock<String> threadSafeList = new ThreadSafeListByReadWriteLock<>();

            executorService.submit(() -> {
                try {
                    System.out.println("start writing element which takes 5 sec: ");
                    threadSafeList.add("element");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            executorService.submit(() -> {
                System.out.println("start reading element (should be blocked by writing until 5 sec later): ");
                threadSafeList.get(0);
            });
        } finally {
            executorService.shutdown();
        }

    }

}
