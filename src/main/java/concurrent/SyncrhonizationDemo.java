/**
 *
 */
package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weiyan.xiang
 * @date 8 Feb 2018
 */
public class SyncrhonizationDemo {

    private static String demoValue = "some demo value";
    private static String staticDemoValue = "some static value!";

    public synchronized void lockedByThis() throws InterruptedException {
        System.out.println("entering synchronized method");
        Thread.sleep(500);
        demoValue = "thread name: " + Thread.currentThread().getName();
        System.out.println("finishing synchronized method, demo value is: " + this.demoValue);
    }

    public static synchronized void lockedByClassLock() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("static synchronized method, staticDemoValue is: " + staticDemoValue);
    }

    public static void lockedBySynchronizedBlock() throws InterruptedException {
        System.out.println("This line is executed without locking");
        synchronized (demoValue) {
            System.out.println("entering synchronized block");
            Thread.sleep(2000);
            System.out.println("synchronized block, demo value is: " + demoValue);
            System.out.println("\n\n\n");
        }
    }

    static class StateHolder {
        private volatile int count;

        public StateHolder(int count) {
            this.count = count;
        }

        public void act() {
            count++;
        }
    }

    /**
     * Synchronized Block
     * <p>
     * Note: if StateHolder.class in below example is null then Java synchronized block will throw a
     * NullPointerException.
     */
    public void actOnClassLevel() {
        StateHolder stateHolder = new StateHolder(1);
        synchronized (StateHolder.class) {
            stateHolder.act();
        }
    }

    /**
     * synchronized (this)  vs synchronized (StateHolder.class) This: "this" make instance level data thread safe. Class
     * level: Class level locking should always be done to make static data thread safe
     */
    public void actOnThis() {
        StateHolder stateHolder = new StateHolder(1);
        synchronized (this) {
            stateHolder.act();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            executorService.submit(() -> {
                try {
                    lockedBySynchronizedBlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            executorService.submit(() -> {
                try {
                    lockedBySynchronizedBlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            // demoWithSyncMethods();
        } finally {
            executorService.shutdown();
        }
    }

    private static void demoWithSyncMethods() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                new SyncrhonizationDemo().lockedByThis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                new SyncrhonizationDemo().lockedByThis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                new SyncrhonizationDemo().lockedByThis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                new SyncrhonizationDemo().lockedByThis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t5 = new Thread(() -> {
            try {
                new SyncrhonizationDemo().lockedByThis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t6 = new Thread(() -> {
            try {
                new SyncrhonizationDemo().lockedByThis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        Thread.sleep(1000);
        System.out.println("eventually the value is: " + demoValue);
    }
}
