/**
 * 
 */
package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weiyan.xiang
 * @date 17 Feb 2018
 */
public class ReentrantLockDemo {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantLock fairLock = new ReentrantLock(true);

    public static void main(String[] args) {
        normalLockDemo();

    }

    private static void normalLockDemo() {
        Thread t1 = getThread("Thread 1");
        Thread t2 = getThread("Thread 2");
        Thread t3 = getThread("Thread 3");
        t1.start();
        t2.start();
        t3.start();
    }

    private static Thread getThread(String threadInfo) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("Enterring thread: " + threadInfo);
                    Thread.sleep(1000);
                    System.out.println("this is " + threadInfo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
    }

}
