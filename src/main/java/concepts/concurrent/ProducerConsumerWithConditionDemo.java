package concepts.concurrent;/**
 * @author Weiyan Xiang on 2022/1/25
 */

import utils.PrintUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class ProducerConsumerWithConditionDemo {

    private static final Logger LOGGER = Logger.getLogger(ProducerConsumerWithConditionDemo.class.getName());

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
                    LOGGER.info("queue is full with 10 elements, await now until it has slots");
                    notFull.await();
                }
                buffer[count++] = 1;
                System.out.print("produced one element, current buffer is: ");
                PrintUtils.printArray(buffer);
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
                    LOGGER.info("queue is empty, await now until it has elements");
                    PrintUtils.printArray(buffer);
                    notEmpty.await();
                }
                buffer[--count] = 0;
                System.out.print("consumed one element, current buffer is: ");
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
