/**
 * 
 */
package knowledge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weiyan.xiang
 * @date 1 Feb 2018
 */
public class StreamDemo {

    public static void main(String[] args) {

        List<String> aList = new ArrayList<>(
                Arrays.asList("apple", "", "cow", "blue", "deer", "yellow", "english", "hello"));
        aList.stream().filter(s -> s.length() > 3).map(String::toUpperCase).collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
