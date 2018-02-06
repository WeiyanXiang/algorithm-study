/**
 * 
 */
package concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weiyan.xiang
 * @date 6 Feb 2018
 */
public class ThreadLocalDemo {

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
    public static class SampleThread implements Runnable {
        private ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
            @Override
            protected SimpleDateFormat initialValue() {
                System.out.println("Thread local created.");
                return new SimpleDateFormat("yyyyMMdd HHmm");
            }
        };

        @Override
        public void run() {
            System.out.println("Thread- " + Thread.currentThread().getName()
                    + " is running, the thread local formted date: " + threadLocal.get().format(new Date()));
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
