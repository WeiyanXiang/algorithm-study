/**
 * 
 */
package concepts.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiyan.xiang
 * @date 18 Feb 2018
 */
public class ThreadUtils {

    public static List<Thread> getThreads(int number, Runnable runnable) {
        int i = 0;
        List<Thread> answer = new ArrayList<>();
        while (i < number) {
            answer.add(new Thread(runnable));
            i++;
        }
        return answer;
    }

    public static void startAll(List<Thread> threads) {
        threads.forEach(t -> t.start());
    }

}
