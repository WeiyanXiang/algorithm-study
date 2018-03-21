/**
 * 
 */
package design.pattern.interceptor;

/**
 * @author weiyan.xiang
 * @date 21 Mar 2018
 */
public class Target {

    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }

}
