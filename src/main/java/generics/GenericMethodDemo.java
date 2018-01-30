/**
 * 
 */
package generics;

import java.util.List;

/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class GenericMethodDemo {

    public static <T, E, U, W, X, Y> boolean compare(GenericClassDemo<T, E, U> obj1, GenericClassDemo<W, E, Y> obj2) {
        return obj1.getElement() != null && obj2.getElement() != null;
    }

    public static void main(String[] args) {
        GenericClassDemo<String, String, String> obj1 = new GenericClassDemo<>("", "", "");
        GenericClassDemo<List<String>, String, String> obj2 = new GenericClassDemo<>(null, "", "");
        System.out.println(
                "GenericMethodDemo.compare( GenericClassDemo<String, String, String> obj1 , GenericClassDemo<List<String>, String, String> obj2): "
                        + GenericMethodDemo.compare(obj1, obj2));
    }

}
