/**
 * 
 */
package design.pattern.interceptor;

/**
 * @author weiyan.xiang
 * @date 21 Mar 2018
 */
public class DebugFilter implements Filter {

    /*
     * (non-Javadoc)
     * 
     * @see design.pattern.interceptor.Filter#execute(java.lang.String)
     */
    @Override
    public void execute(String request) {
        System.out.println("request log: " + request);
    }

}
