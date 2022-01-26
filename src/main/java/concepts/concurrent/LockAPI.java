package concepts.concurrent;/**
 * @author Weiyan Xiang on 2022/1/25
 */

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAPI {
    Lock lock = new ReentrantLock();

    public void lockDemo() {
        lock.lock();
        try {
            //
        } finally {
            lock.unlock();
        }
    }

    public void tryLockDemo() {
        boolean acquiredLock = lock.tryLock();
        if (acquiredLock) {
            try {
                //
            } finally {
                lock.unlock();
            }
        } else {

        }
    }

    public void tryLockWithTimeDemo() {
        try {
            boolean tryLock = lock.tryLock(1000, TimeUnit.MILLISECONDS);
            if (tryLock) {
                try {

                } finally {
                    lock.unlock();
                }
            } else {

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void lockInterruptilyDemo() {
        try {
            lock.lockInterruptibly();
            try {
                //
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
