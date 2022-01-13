/**
 *
 */
package knowledge.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weiyan.xiang
 * @date 1 Feb 2018
 */
public class StreamDemo {

    public static void main(String[] args) {
        System.out.println("Demo stream usage: ");
        demoStream();

        System.out.println("\nCompare stream and parallel stream usage: ");
        compareWithParallelStreams();

        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().reduce(0, (sub, ele) -> sub + ele) + " == 15");
    }

    private static void demoStream() {
        List<String> aList = new ArrayList<>(
                Arrays.asList("apple", "", "cow", "blue", "deer", "yellow", "english", "hello"));
        aList.stream().filter(s -> s.length() > 3).map(String::toUpperCase).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("--------------------------------------");

        List<List<String>> listOfList = new ArrayList<>();
        listOfList.addAll(Arrays.asList(Arrays.asList("apple"), Arrays.asList("cow"), Arrays.asList("blue"), Arrays.asList("deer"), Arrays.asList("yellow"), Arrays.asList("hello")));
        listOfList.stream().map(Collection::stream).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("/////////////////////////////////////");
        listOfList.stream().flatMap(Collection::stream).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void compareWithParallelStreams() {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));

        intList.stream().forEach(
                s -> System.out.println("Current Thread - " + Thread.currentThread().getName() + " ," + s + ", "));

        System.out.println("--------------------------------------------------------------");

        intList.parallelStream().forEach(
                s -> System.out.println("Current Thread - " + Thread.currentThread().getName() + ", " + s + ", "));
    }
}
