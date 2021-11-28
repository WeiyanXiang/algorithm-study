package concepts.concurrent;/**
 * @author Weiyan Xiang on 2021/11/27
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StackClosedExample {

    public void addNum() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) cnt++;
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        StackClosedExample example = new StackClosedExample();
        executorService.execute(() -> example.addNum());
        executorService.execute(() -> example.addNum());
        executorService.shutdown();
    }

}
