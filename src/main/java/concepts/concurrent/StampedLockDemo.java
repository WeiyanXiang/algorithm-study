package concepts.concurrent;/**
 * @author Weiyan Xiang on 2022/1/15
 */

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    private final StampedLock sl = new StampedLock();
    private volatile double balance;

    public void withdraw(long amount) {
        long stamp = sl.writeLock();
        try {
            balance -= amount;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    public double getBalance() {
        long stamp = sl.readLock();
        try {
            return balance;
        } finally {
            sl.unlockRead(stamp);
        }
    }

    public double getBalanceReadOptimistic() {
        long stamp = sl.tryOptimisticRead();
        double balance = this.balance;
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
                balance = this.balance;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return balance;
    }

}
