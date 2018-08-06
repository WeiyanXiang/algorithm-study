/**
 * 
 */
package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class GenericMethodDemo {

    /**
     * generic methods
     * 
     * @param obj1
     * @param obj2
     * @return
     */
    public static <T, E, U, W, X, Y> boolean compare(GenericClassDemo<T, E, U> obj1, GenericClassDemo<W, E, Y> obj2) {
        return obj1.getElement() != null && obj2.getElement() != null;
    }

    /*
     * Generic Methods and Bounded Type Parameters
     * 
     */
    public static <T extends List<?>> void inspect(T input) {
        System.out.println("input class type is: " + input.getClass().getName());
    }

    /*
     * Generic Methods and multiple Bounded Type Parameters
     * 
     */
//    public static <T extends List<?> & Map<?, ?>> void inspectMulti(T input) {
//        System.out.println("input class type is: " + input.getClass().getName());
//    }

    public static void main(String[] args) {
        GenericClassDemo<String, String, String> obj1 = new GenericClassDemo<>("", "", "");
        GenericClassDemo<List<String>, String, String> obj2 = new GenericClassDemo<>(null, "", "");
        System.out.println(
                "GenericMethodDemo.compare( GenericClassDemo<String, String, String> obj1 , GenericClassDemo<List<String>, String, String> obj2): "
                        + compare(obj1, obj2));

        inspect(new ArrayList<String>());
        // inspect("a string will not compile");
    }

}
