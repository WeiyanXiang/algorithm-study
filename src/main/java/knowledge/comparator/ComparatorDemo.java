/**
 * 
 */
package knowledge.comparator;

import java.util.Comparator;

/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class ComparatorDemo implements Comparator<String> {

    /**
     * comparator is in java.util, it performs more like a util and can be
     * sorted in Collections.sort(List,Comparator)
     */
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

}
