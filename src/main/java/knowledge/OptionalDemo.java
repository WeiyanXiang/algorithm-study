/**
 * 
 */
package knowledge;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author weiyan.xiang
 * @date 26 Jan 2018
 */
public class OptionalDemo {

    private String demoField;

    /**
     * @param demoField
     */
    public OptionalDemo(String demoField) {
        this.demoField = demoField;
    }

    public Optional<String> getDemoField() {
        return Optional.ofNullable(demoField);
    }

    public void setDemoField(String demoField) {
        this.demoField = demoField;
    }

    public static void testOptionalBasic() {
        Optional<Integer> emptyIntegerInstance = Optional.empty();
        System.out.println("emptyIntegerInstance: " + emptyIntegerInstance.orElse(12));
        Optional<String> obj1 = Optional.of("value");
        Optional<Object> obj2 = Optional.ofNullable(null);
        System.out.println("Optional.of(\"value\"): " + obj1.get());
        System.out.println("Optional.ofNullable(null)): " + obj2.orElse("null"));
    }

    public static void testOptionalMap() {
        Optional<String> emptyIntegerInstance = Optional.empty();
        System.out.println("emptyIntegerInstance: " + emptyIntegerInstance.map(value -> value.toUpperCase()));
        System.out.println("emptyIntegerInstance: " + emptyIntegerInstance.map(String::toUpperCase));
        /*
         * dif between map and flatMap
         */
        Optional<Optional<String>> obj1 = Optional.of(Optional.of("a string"));
        System.out.println("Optional.map: " + obj1.map(element -> element.map(String::toUpperCase)));
        // flatMap will fold all nested optional and return a flat one
        System.out.println("Optional.flatMap: " + obj1.flatMap(element -> element.map(String::toUpperCase)));
    }

    public static void testOptionalFilter() {
        Optional<String> testObj1 = Optional.empty();
        Optional<String> testObj2 = Optional.of("a string");
        System.out.println("Optional empty => " + testObj1.filter(element -> element.equals("A STRING")));
        System.out.println("Optional empty => " + testObj1.filter(element -> element.equalsIgnoreCase("A STRING")));
        System.out
                .println("Optional [a string] => " + testObj2.filter(element -> element.equalsIgnoreCase("A STRING")));
    }

    public static void testOptionalIsPresent() {
        Optional<String> testObj1 = Optional.empty();
        Optional<String> testObj2 = Optional.of("a string");
        System.out.println("false => " + testObj1.isPresent());
        testObj2.ifPresent(element -> System.out.println("A STRING == " + element.toUpperCase()));
    }

    public static void testOptionalOrElse() {
        Optional<String> testObj1 = Optional.empty();
        Optional<String> testObj2 = Optional.of("a string");
        System.out.println("empty == " + testObj1.orElse("empty"));
        System.out.println("empty == " + testObj1.orElseGet(() -> "empty"));
        System.out.println("a string == " + testObj2.orElse("empty"));
        System.out.println("empty == " + testObj1.orElseGet(() -> {
            System.out.println("do something here as Supplier method");
            return "empty";
        }));
    }

    public static void main(String[] args) {
        OptionalDemo testObj = new OptionalDemo(null);
        Optional<String> demoField = testObj.getDemoField();
        System.out.println("false == " + demoField.isPresent());
        System.out.println("we should expect to see replacement string rather than null => " + demoField.orElse("$$$"));
        testObj.setDemoField("test value");
        Optional<String> anotherDemoField = testObj.getDemoField();
        if (anotherDemoField.isPresent()) {
            System.out.println("test value => " + anotherDemoField.get());
        }
        testOptionalBasic();
        testOptionalMap();
        testOptionalFilter();
        testOptionalIsPresent();
        testOptionalOrElse();

        /*
         * a bit exploring in stream, will give a deep learning following on
         */
        List<String> test = Arrays.asList("t1", "t2", "t3");
        test.stream().map(element -> element.toUpperCase()).forEach(System.out::println);
        test.stream().map(String::toLowerCase).distinct().sorted().forEach(System.out::println);
    }
}
