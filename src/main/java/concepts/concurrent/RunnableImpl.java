/**
 * 
 */
package concepts.concurrent;

/**
 * @author weiyan.xiang
 * @date 28 Jan 2018
 */
public class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println("RunnableImpl is invoked");
    }

}
