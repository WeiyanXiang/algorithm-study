/**
 * 
 */
package design.pattern.interceptor;

/**
 * Filter which will performs certain task prior or after execution of request
 * by request handler.
 * 
 * @author weiyan.xiang
 * @date 21 Mar 2018
 */
public interface Filter {
    void execute(String request);
}
