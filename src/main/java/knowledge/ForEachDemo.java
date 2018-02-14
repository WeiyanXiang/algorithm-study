/**
 * 
 */
package knowledge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weiyan.xiang
 * @date 13 Feb 2018
 */
public class ForEachDemo {

    /*
     * • If we are not doing too much processing, the major timing is in
     * accessing element, then the stream is not fast as compared to foreach.
     * For this reason, the benchmarks illustrate the cost of element access
     * mainly.
     */
    private static void forEachDemo() {
        List<Integer> aList = new ArrayList<>(Arrays.asList(1, 2, 4, 2, 5, 2, 5, 1, 4, 21));
        System.out.println("below is enhanced for each with indexes");
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < aList.size(); i++) {
            System.out.print(aList.get(i) + ", ");
        }
        long e1 = System.currentTimeMillis();
        System.out.println("Total execution time: " + (e1 - s1) + "ms");

        System.out.println("\nbelow is enhanced for each without indexes");
        long s2 = System.currentTimeMillis();
        for (Integer element : aList) {
            System.out.print(element + ", ");
        }
        long e2 = System.currentTimeMillis();
        System.out.println("Total execution time: " + (e2 - s2) + "ms");

        System.out.println("\nbelow is foreach lambda");
        long s3 = System.currentTimeMillis();
        aList.forEach(e -> System.out.print(e + ", "));
        long e3 = System.currentTimeMillis();
        System.out.println("Total execution time: " + (e3 - s3) + "ms");
    }

    public static void main(String[] args) {
        forEachDemo();
    }

}
