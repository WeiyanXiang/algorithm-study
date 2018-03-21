/**
 * 
 */
package design.pattern.interceptor;

/**
 * Target object is the request handler
 * 
 * @author weiyan.xiang
 * @date 21 Mar 2018
 */
public class Target {

    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }

}
