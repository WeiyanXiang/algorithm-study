/**
 *
 */
package concepts.concurrent;

import java.util.concurrent.Callable;

/**
 * @author weiyan.xiang
 * @date 28 Jan 2018
 */
public class CallableImpl implements Callable<String> {

    @Override
    public String call() {
        String callable = "CallableImpl is invoked";
        System.out.println(callable);
        return callable;
    }

}
