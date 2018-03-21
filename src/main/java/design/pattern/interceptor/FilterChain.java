/**
 * 
 */
package design.pattern.interceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter Chain carries multiple filters and help to execute them in defined
 * order on target.
 * 
 * @author weiyan.xiang
 * @date 21 Mar 2018
 */
public class FilterChain {

    private List<Filter> filters = new ArrayList<>();
    private Target target;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
