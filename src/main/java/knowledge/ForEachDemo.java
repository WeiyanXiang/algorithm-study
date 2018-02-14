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

    private static void forEachDemo() {
        List<Integer> aList = new ArrayList<>(Arrays.asList(1, 2, 4, 2, 5, 2, 5, 1, 4, 21));
        System.out.println("below is enhanced for each with indexes");
        for (int i = 0; i < aList.size(); i++) {
            System.out.print(aList.get(i) + ", ");
        }

        System.out.println("\nbelow is enhanced for each without indexes");
        for (Integer element : aList) {
            System.out.print(element + ", ");
        }

        System.out.println("\nbelow is foreach lambda");
        aList.forEach(e -> System.out.print(e + ", "));
    }

    public static void main(String[] args) {
        forEachDemo();
    }

}
