/**
 * 
 */
package concepts.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weiyan.xiang
 * @date 18 Feb 2018
 */
public class ReentrantLockOnCounterDemo {

    private static final ReentrantLock lock = new ReentrantLock(true);
    private volatile static int count = 0;

    private static int getCount() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
            return ++count;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getCount();

            }
        };
        ThreadUtils.startAll(ThreadUtils.getThreads(10, runnable));
    }

}
