package knowledge.lambda.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Weiyan Xiang on 2018/8/7
 * <p>
 * https://www.concretepage.com/java/jdk-8/java-8-stream-collect-example#collect
 */
public class CollectorDemo {

    /**
     * The syntax of Stream.collect() using supplier, accumulator, combiner is as follows.
     * <p>
     * collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)
     * <p>
     * <p>
     * supplier : It creates a new result container which will be populated by accumulator and combiner and finally it
     * will be returned by collect() method. In parallel processing the Supplier function will be called multiple times
     * that will return fresh value each time.
     * <p>
     * accumulator : It incorporates additional element into the result.
     * <p>
     * combiner : It combines two values that must be compatible with accumulator. Combiner works in parallel
     * processing.
     * <p>
     * https://stackoverflow.com/questions/31533316/about-collect-supplier-accumulator-combiner The combiner is used
     * when your Stream is parallel, since in that case several threads collect elements of the Stream into sub-lists of
     * the final output ArrayList, and these sub-lists have to be combined to produce the final output.
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Mukesh", "Vishal", "Amar");
        String result = list.parallelStream().collect(StringBuilder::new,
                (response, element) -> response.append(" ").append(element),
                (response1, response2) -> response1.append(",").append(response2.toString()))
                .toString();
        System.out.println("Result: " + result);
    }
}
