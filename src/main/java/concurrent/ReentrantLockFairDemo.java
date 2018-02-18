/**
 * 
 */
package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weiyan.xiang
 * @date 18 Feb 2018
 */
public class ReentrantLockFairDemo {

    private static final ReentrantLock fairLock = new ReentrantLock(true);

    private static void fairLockDemo() throws InterruptedException {
        Thread t1 = getThreadWithFairLock("Thread 0", 80);
        Thread t2 = getThreadWithFairLock("Thread 1", 80);
        Thread t3 = getThreadWithFairLock("Thread 2", 80);
        Thread t4 = getThreadWithFairLock("Thread 3", 80);
        Thread t5 = getThreadWithFairLock("Thread 4", 80);
        Thread t6 = getThreadWithFairLock("Thread 5", 80);
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
                    System.out.println("Enterring thread: " + threadInfo + ", trying to get the lock.");
                    Thread.sleep(10);
                    System.out.println("This is " + threadInfo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    fairLock.unlock();
                }
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        fairLockDemo();
    }
}
