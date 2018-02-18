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

    public static void main(String[] args) throws InterruptedException {
        normalLockDemo();
        // System.out.println("---------------------------------------------");
        // fairLockDemo();

    }

    private static void fairLockDemo() throws InterruptedException {
        Thread t1 = getThreadWithFairLock("Thread 11", 1000);
        Thread t2 = getThreadWithFairLock("Thread 22", 800);
        Thread t3 = getThreadWithFairLock("Thread 33", 600);
        Thread t4 = getThreadWithFairLock("Thread 44", 400);
        Thread t5 = getThreadWithFairLock("Thread 55", 200);
        Thread t6 = getThreadWithFairLock("Thread 66", 0);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

    private static Thread getThreadWithFairLock(String threadInfo, int waitingLength) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                fairLock.lock();
                try {
                    System.out.println("Enterring thread: " + threadInfo);
                    Thread.sleep(waitingLength);
                    System.out.println("this is " + threadInfo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    fairLock.unlock();
                }
            }
        });
    }

    /*
     * 3 threads, the order or exec may differs, so the safest tryLock timeout
     * is 10 + 10ms which is over 20ms
     * 
     */
    private static void normalLockDemo() {
        Thread t1 = getThread("Thread 0", 25);
        Thread t2 = getThread("Thread 1", 25);
        Thread t3 = getThread("Thread 2", 25);
        t1.start();
        t2.start();
        t3.start();
    }

    private static Thread getThread(String threadInfo, int waitingLength) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Enterring thread: " + threadInfo + ", trying to get the lock.");
                    if (lock.tryLock(waitingLength, TimeUnit.MILLISECONDS)) {
                        Thread.sleep(10);
                        System.out.println("This is " + threadInfo);
                    }
                    System.out.println("Finishing current thread: " + threadInfo);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
    }

}
