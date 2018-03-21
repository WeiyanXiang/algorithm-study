/**
 * 
 */
package design.pattern.interceptor;

/**
 * Client is the object who sends request to the Target object.
 * 
 * @author weiyan.xiang
 * @date 21 Mar 2018
 */
public class Client {

    private FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void sendRequest(String request) {
        filterManager.filterRequest(request);
    }

}
