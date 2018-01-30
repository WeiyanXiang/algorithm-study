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

    public static void main(String[] args) {
        int test1 = 0b0101_0110;
        System.out.println(test1);
    }
}
