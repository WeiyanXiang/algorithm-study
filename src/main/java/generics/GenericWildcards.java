/**
 * 
 */
package generics;

import java.util.List;

/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class GenericWildcards {

    /**
     * unbounded wildcard
     * 
     * @param aList
     */
    public static void setList(List<?> aList) {
    }

    /**
     * upper bounded wildcard
     * 
     * @param aList
     */
    public static void setAnotherListUpperBounded(List<? extends Number> aList) {
    }

    /**
     * lower bounded wildcard
     * 
     * @param aList
     */
    public static void setAnotherListLowerBounded(List<? super Integer> aList) {
    }
}
