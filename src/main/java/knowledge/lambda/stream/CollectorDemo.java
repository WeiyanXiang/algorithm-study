package knowledge.lambda.stream;

import knowledge.lambda.predicate.Employee;

import java.util.*;
import java.util.stream.Collectors;

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

        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        /**
         * https://stackoverflow.com/questions/45231351/java-stream-collect-map-which-contains-list
         */
        List<Employee> employees = new ArrayList<>();
        employees.addAll(Arrays.asList(new Employee[]{e1, e2, e3, e4, e5, e6, e7, e8, e9, e10}));
        Map<Integer, Integer> employeeMap = employees.stream().collect(Collectors.toMap(e -> e.id, e -> e.age));
        employeeMap.entrySet().stream().forEach(System.out::println);
        Map<String, List<Employee>> groupedMap = employees.stream().collect(Collectors.groupingBy(Employee::getGender));
        groupedMap.entrySet().stream().forEach(System.out::println);
    }
}
