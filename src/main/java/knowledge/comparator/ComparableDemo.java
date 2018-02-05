/**
 * 
 */
package knowledge.comparator;

/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class ComparableDemo implements Comparable<Integer> {

    private int value;

    /**
     * comparable is in java.lang, it can be provided by default if needed and
     * can be sorted in Collections.sort(List) directly
     */
    @Override
    public int compareTo(Integer o) {
        return this.value - o;
    }

}
