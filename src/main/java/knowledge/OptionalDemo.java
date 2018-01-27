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
        Optional<List<String>> obj1 = Optional.of(Arrays.asList("t1", "t2", "t3"));
        // System.out.println("Optional.of(\"value\"): " + obj1.map());
        // System.out.println("Optional.ofNullable(null)): " +
        // obj2.orElse("null"));

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
        List<String> test = Arrays.asList("t1", "t2", "t3");

        /*
         * a bit exploring in stream, will give a deep learning following on
         */
        test.stream().map(element -> element.toUpperCase()).forEach(System.out::println);
        test.stream().map(String::toLowerCase).distinct().sorted().forEach(System.out::println);
    }
}
