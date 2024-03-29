/**
 *
 */
package concepts.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author weiyan.xiang
 * @date 6 Feb 2018
 */
public class ThreadLocalDemo {

    /**
     * common usage of threadLocal: You can wrap any non Thread Safe object in
     * ThreadLocal and suddenly its uses becomes Thread-safe, as its only being
     * used by Thread Safe. One of the classic example of ThreadLocal is sharing
     * SimpleDateForamt. Since SimpleDateFormat is not thread safe, having a
     * global formatter may not work but having per Thread formatter will
     * certainly work.
     *
     * 在一些场景 (尤其是使用线程池) 下，由于 ThreadLocal.ThreadLocalMap 的底层数据结构导致 ThreadLocal 有内存泄漏的情况，
     * 应该尽可能在每次使用 ThreadLocal 后手动调用 remove()，以避免出现 ThreadLocal 经典的内存泄漏甚至是造成自身业务混乱的风险。
     *
     **/
    public static class SampleThread implements Runnable {

        private ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> {
            System.out.println("Thread local created.");
            return new SimpleDateFormat("yyyyMMdd HHmm");
        });

        @Override
        public void run() {
            System.out.println("Thread- " + Thread.currentThread().getName()
                    + " is running, the thread local formted date: " + threadLocal.get().format(new Date()));
        }
    }

    public static class SampleThreadAnother implements Runnable {

        private int threadLocalRandom = ThreadLocalRandom.current().nextInt();

        @Override
        public void run() {
            System.out.println("Thread- " + Thread.currentThread().getName()
                    + " is running, the thread local random number is: " + threadLocalRandom);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new SampleThread());
        Thread t2 = new Thread(new SampleThread());
        t1.start();
        t2.start();

        Thread t3 = new Thread(new SampleThreadAnother());
        Thread t4 = new Thread(new SampleThreadAnother());

        t3.start();
        t4.start();
    }

}
