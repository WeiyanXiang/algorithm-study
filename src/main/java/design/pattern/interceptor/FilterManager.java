/**
 * 
 */
package design.pattern.interceptor;

/**
 * Filter Manager manages the filters and Filter Chain.
 * 
 * @author weiyan.xiang
 * @date 21 Mar 2018
 */
public class FilterManager {

    private FilterChain filterChain;

    /**
     * @param filterChain
     */
    public FilterManager(Target target) {
        this.filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }

}
