/**
 * 
 */
package concurrent;

import java.util.concurrent.Callable;

/**
 * @author weiyan.xiang
 * @date 28 Jan 2018
 */
public class CallalableImpl implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("CallalableImpl is invoked");
        return "CallalableImpl is invoked";
    }

}
