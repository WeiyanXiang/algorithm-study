package concepts.concurrent;
/**
 * @author Weiyan Xiang on 2022/1/23
 */

import java.util.*;

public class ThreadJoinExample {

    public static void main(String[] args) {
        ThreadJoinExample threadJoinExample = new ThreadJoinExample();
        threadJoinExample.test();
    }

    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread {

        private A a;

        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }
}
