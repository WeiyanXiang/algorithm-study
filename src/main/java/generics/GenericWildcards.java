/**
 * 
 */
package generics;

import java.util.ArrayList;
import java.util.Arrays;
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
        aList.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        int test1 = 0b1010110;
        System.out.println(test1);

        setAnotherListUpperBounded(Arrays.asList(1, 2, 1.1f, 1.3d));
        // setAnotherListUpperBounded(Arrays.asList(1, 1, "this will not compile
        // due to wild card bound"));
        List<?> wildCardList = new ArrayList<>();
        // wildCardList.add("test"); // this will not compile
        // setAnotherListLowerBounded(Arrays.asList(1, 2.1, "dsa"));
    }
}
