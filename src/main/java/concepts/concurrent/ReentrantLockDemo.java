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

}
