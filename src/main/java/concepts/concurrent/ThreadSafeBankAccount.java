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

        /**
         * volatile guarantees visibility so we dont need additional synchronized for reading
         */
        public long getBalance() {
            return balance;
        }

    }

    public class BankAccountImmutable {
        private final float balance;

        public BankAccountImmutable(float balance) {
            this.balance = balance;
        }

        public BankAccountImmutable deposit(float amount) {
            return new BankAccountImmutable(balance + amount);
        }

        public BankAccountImmutable withdraw(float amount) {
            return new BankAccountImmutable(balance - amount);
        }

        /**
         * primitive type is immutable by nature
         */
        public float getBalance() {
            return balance;
        }
    }
}
