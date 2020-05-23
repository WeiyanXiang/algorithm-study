package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Weiyan Xiang on 2020/3/26
 * <p>
 * https://www.baeldung.com/java-atomic-variables
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {
    }

    /**
     * thread safe counter with lock
     */
    public class SafeCounterWithLock {
        private volatile int counter;

        public synchronized void increment() {
            counter++;
        }
    }

    /**
     * thread safe counter with Atomic integer
     */
    public class SafeCounterWithoutLock {
        private final AtomicInteger counter = new AtomicInteger(0);

        public int getValue() {
            return counter.get();
        }

        /**
         * below while true and compareAndSet is because wanting to keep counter running,
         */
        public void increment() {
            while (true) {
                int existingValue = getValue();
                int newValue = existingValue + 1;
                if (counter.compareAndSet(existingValue, newValue)) {
                    return;
                }
            }
        }

        /**
         * thread-safe simply can do getAndIncrement
         */
        public void incrementSimple() {
            counter.getAndIncrement();
        }
    }
}
