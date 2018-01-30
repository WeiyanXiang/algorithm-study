/**
 * 
 */
package generics;

import java.util.Arrays;
import java.util.List;

/**
 * @author weiyan.xiang
 * @date 29 Jan 2018
 */

/*
 * A raw type is the name of a generic class or interface without any type
 * arguments. For example, given the generic Box class:
 * 
 * 
 */
public class GenericClassDemo<T, E, U> {
    private T name;
    private E element;
    private U unique;

    /**
     * @param name
     * @param element
     * @param unique
     */
    public GenericClassDemo(T name, E element, U unique) {
        this.name = name;
        this.element = element;
        this.unique = unique;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public U getUnique() {
        return unique;
    }

    public void setUnique(U unique) {
        this.unique = unique;
    }

    public static void main(String[] args) {
        GenericClassDemo<String, String, String> testObj = new GenericClassDemo<>("", "element", "");
        System.out.println("expected element value in string  is: " + testObj.getElement());
        GenericClassDemo<List<String>, Integer, String> anotherObj = new GenericClassDemo<>(Arrays.asList(""), 2, "");
        System.out.println("expected element value in integer is: " + anotherObj.getElement());
    }

}
