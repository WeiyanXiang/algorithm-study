package concepts.concurrent;/**
 * @author Weiyan Xiang on 2022/1/20
 */

import java.util.concurrent.atomic.AtomicLong;

public class ThreadSafeBankAccount {
    class BankAccountAtomic {
        private final AtomicLong balance;

        public BankAccountAtomic(AtomicLong balance) {
            this.balance = balance;
        }

        public void deposit(long amount) {
            balance.addAndGet(amount);
        }

        public void withdraw(long amount) {
            balance.addAndGet(-amount);
        }

        public long getBalance() {
            return balance.get();
        }
    }

    class BankAccountSyncVolatile {
        private volatile Long balance;

        public void deposit(long amount) {
            synchronized (balance) {
                balance += amount;
            }
        }

        public void withdraw(long amount) {
            synchronized (balance) {
                balance -= amount;
            }
        }

        public long getBalance() {
            return balance;
        }

    }
}
