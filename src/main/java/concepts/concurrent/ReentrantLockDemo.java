/**
 *
 */
package concepts.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weiyan.xiang
 * @date 17 Feb 2018
 */
public class ReentrantLockDemo {

    Lock lock = new ReentrantLock();

    public void lockAFunction() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        } finally {
            lock.unlock();
        }
    }

    public void tryLockAFunction() {
        try {
            boolean flag = lock.tryLock(100, TimeUnit.MILLISECONDS);
            if (flag) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is locked.");
                    System.out.println("performing task");
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + "is unlocked");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void lockInterruptilyAFunction() {
        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + " is locked.");
                System.out.println("performing task");
                Thread.sleep(1000);
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "is unlocked");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
