package concurrent;

/**
 * @author Weiyan Xiang on 2020/10/14
 */
public class CounterMultiThreadDemo {

    public static class Counter {

        long count = 0;

        public synchronized void add() {
            this.count++;
            System.out.println(count);
        }
    }

    public static class CounterThread extends Thread {

        protected Counter counter = null;

        public CounterThread(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                counter.add();
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();
    }

}
