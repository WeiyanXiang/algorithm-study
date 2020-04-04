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

    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock(true);
    private static final int WAITING_LENGTH = 600;

    /*
     * fairness allows LOCK prefers to be given to longest w8 thread; tryLock
     * will Not respect fairness
     */
    public static void main(String[] args) {
        lockWithFair();
//        lockWithNormal();

    }

    private static void lockWithNormal() {
        Thread t1 = getThreadWithNormalLock("T-0", WAITING_LENGTH);
        Thread t2 = getThreadWithNormalLock("T-1", WAITING_LENGTH);
        Thread t3 = getThreadWithNormalLock("T-2", WAITING_LENGTH);
        Thread t4 = getThreadWithNormalLock("T-3", WAITING_LENGTH);
        Thread t5 = getThreadWithNormalLock("T-4", WAITING_LENGTH);
        Thread t6 = getThreadWithNormalLock("T-5", WAITING_LENGTH);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

    private static void lockWithFair() {
        Thread t1 = getThreadWithFairLock("T-0", WAITING_LENGTH);
        Thread t2 = getThreadWithFairLock("T-1", WAITING_LENGTH);
        Thread t3 = getThreadWithFairLock("T-2", WAITING_LENGTH);
        Thread t4 = getThreadWithFairLock("T-3", WAITING_LENGTH);
        Thread t5 = getThreadWithFairLock("T-4", WAITING_LENGTH);
        Thread t6 = getThreadWithFairLock("T-5", WAITING_LENGTH);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

    private static Thread getThreadWithFairLock(String threadInfo, int waitingLength) {
        return new Thread(() -> {
            try {
                if (REENTRANT_LOCK.tryLock() || REENTRANT_LOCK.tryLock(waitingLength, TimeUnit.SECONDS)) {
                    Thread.sleep(100);
                    System.out.println("Entering FAIR: " + Thread.currentThread().getName() + ", Queue length: "
                            + REENTRANT_LOCK.getQueueLength() + ", Hold count: " + REENTRANT_LOCK.getHoldCount());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                REENTRANT_LOCK.unlock();
            }
        }, threadInfo);
    }

    private static Thread getThreadWithNormalLock(String threadInfo, int waitingLength) {
        return new Thread(() -> {
            try {
                if (LOCK.tryLock(waitingLength, TimeUnit.SECONDS)) {
                    Thread.sleep(100);
                    System.out.println("Entering NORMAL: " + Thread.currentThread().getName() + ", Queue length: "
                            + LOCK.getQueueLength() + ", Hold count: " + LOCK.getHoldCount());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }, threadInfo);
    }


}
