package concepts.concurrent;/**
 * @author Weiyan Xiang on 2022/1/25
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithConditionDemo {
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();
    int[] buffer = new int[10];
    int count = 0;

    class Producer {
        public void produce() {
            try {
                lock.lock();
                while (count == 9) {
                    notFull.await();
                }
                buffer[count++] = 1;
                notEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } finally {
                lock.lock();
            }
        }
    }

    class Consumer {
        public void consume() {
            try {
                lock.lock();
                while (count == 0) {
                    notEmpty.await();
                }
                buffer[--count] = 0;
                notFull.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }


}
