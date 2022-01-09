package concepts.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Weiyan Xiang on 2022/1/9
 */

public class ThreadInterrupt {
    static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * interrupted() 如果一个线程的 run() 方法执行一个无限循环，并且没有执行 sleep() 等会抛出 InterruptedException 的操作，那么调用线程的 interrupt()
     * 方法就无法使线程提前结束。
     * <p>
     * 但是调用 interrupt() 方法会设置线程的中断标记，此时调用 interrupted() 方法会返回 true。因此可以在循环体中使用 interrupted() 方法来判断线程是否处于中断状态，从而提前结束线程。
     */
    static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                System.out.println("Thread running");
            }
            System.out.println("Thread run");
        }
    }


    public void interruptMyThread() {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        myThread1.interrupt();

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        myThread2.interrupt();
    }

    public void interruptExecutor() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        /**
         调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭，但是如果调用的是 shutdownNow() 方法，
         则相当于调用每个线程的 interrupt() 方法。
         以下使用 Lambda 创建线程，相当于创建了一个匿名内部线程。
         **/
        executorService.shutdown();
//        executorService.shutdownNow();

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        Future<?> future = executorService2.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        /**
         * 如果只想中断 Executor 中的一个线程，可以通过使用 submit() 方法来提交一个线程，它会返回一个 Future<?> 对象，通过调用该对象的 cancel(true) 方法就可以中断线程。
         */
        future.cancel(true);

    }


}
