/**
 * 
 */
package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weiyan.xiang
 * @date 17 Feb 2018
 */
public class ReentrantLockDemo {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantLock fairLock = new ReentrantLock(true);

    /*
     * fairness allows lock prefers to be given to longest w8 thread; tryLock
     * will Not respect fairness
     */
    public static void main(String[] args) throws InterruptedException {
        // lockDemo(false);
        lockDemo(false);

    }

    /*
     * 3 threads, the order or exec may differs, so the safest tryLock timeout
     * is 10 + 10ms which is over 20ms
     * 
     */
    private static void lockDemo(boolean isFair) {
        String fairness = isFair ? "FAIR" : "NORMAL";
        System.out.println("lock each thread using " + fairness + " ReentrantLock");
        Thread t1 = getThread("Thread 0", 80, isFair);
        Thread t2 = getThread("Thread 1", 80, isFair);
        Thread t3 = getThread("Thread 2", 80, isFair);
        Thread t4 = getThread("Thread 3", 80, isFair);
        Thread t5 = getThread("Thread 4", 80, isFair);
        Thread t6 = getThread("Thread 5", 80, isFair);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

    private static Thread getThread(String threadInfo, int waitingLength, boolean isFair) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (isFair) {
                        fairLock.lock();
                        Thread.sleep(100);
                        System.out.println(
                                "Enterring FAIR thread: " + Thread.currentThread().getName() + ", Queue length: "
                                        + fairLock.getQueueLength() + ", Hold count: " + fairLock.getHoldCount());
                    } else {
                        if (lock.tryLock(waitingLength, TimeUnit.MILLISECONDS)) {
                            Thread.sleep(10);
                            System.out.println(
                                    "Enterring NORMAL thread: " + Thread.currentThread().getName() + ", Queue length: "
                                            + lock.getQueueLength() + ", Hold count: " + lock.getHoldCount());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (isFair) {
                        fairLock.unlock();
                    } else {
                        lock.unlock();
                    }
                }
            }
        }, threadInfo);
    }

}
