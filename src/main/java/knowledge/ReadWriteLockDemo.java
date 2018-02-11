/**
 * 
 */
package knowledge;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author weiyan.xiang
 * @date 11 Feb 2018
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock().lock();
        lock.readLock().unlock();

        lock.writeLock().lock();
        if (lock.writeLock().tryLock()) {
            try {
                System.out.println("test write lock");
            } finally {
                lock.writeLock().unlock();
            }
        }

    }

}
