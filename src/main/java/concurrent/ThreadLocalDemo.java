/**
 * 
 */
package concurrent;

import static java.lang.Math.random;
import static java.lang.Math.round;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weiyan.xiang
 * @date 6 Feb 2018
 */
public class ThreadLocalDemo {

    public static class SampleThread implements Runnable {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        /**
         * This example creates a single MyRunnable instance which is passed to
         * two different threads. Both threads execute the run() method, and
         * thus sets different values on the ThreadLocal instance. If the access
         * to the set() call had been synchronized, and it had not been a
         * ThreadLocal object, the second thread would have overridden the value
         * set by the first thread.
         */
        @Override
        public void run() {
            threadLocal.set((int) round(random() * 100));
            System.out.println("a thread is running, random value is: " + threadLocal.get());
        }
    }

    /*
     * common usage of threadLocal: You can wrap any non Thread Safe object in
     * ThreadLocal and suddenly its uses becomes Thread-safe, as its only being
     * used by Thread Safe. One of the classic example of ThreadLocal is sharing
     * SimpleDateForamt. Since SimpleDateFormat is not thread safe, having a
     * global formatter may not work but having per Thread formatter will
     * certainly work.
     * 
     * 
     */
    public static class AnotherSampleThread implements Runnable {
        private ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyyMMdd HHmm");
            }
        };

        @Override
        public void run() {
            System.out.println(this.threadLocal.get().format(new Date()));
        }
    }

    public static void main(String[] args) {
        SampleThread instance = new SampleThread();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();
    }

}
