package knowledge.lambda.functional;

/**
 * @author Weiyan Xiang on 2018/8/6
 */

/**
 * https://howtodoinjava.com/java8/functional-interface-tutorial/
 * <p>
 * Below is list of things which are allowed and which are not in a functional interface.
 * <p>
 * A) As discussed above, only one abstract method is allowed in any functional interface. Second abstract method is not
 * not permitted in a functional interface. If we remove @FunctionInterface annotation then we are allowed to add
 * another abstract method, but it will make the interface non-functional interface.
 * <p>
 * B) A functional interface is valid even if the @FunctionalInterface annotation would be omitted. It is only for
 * informing the compiler to enforce single abstract method inside interface.
 * <p>
 * C) Conceptually, a functional interface has exactly one abstract method. Since default methods have an
 * implementation, they are not abstract. Since default methods are not abstract you’re free to add default methods to
 * your functional interface as many as you like. Below is valid functional interface:
 * <p>
 * D) If an interface declares an abstract method overriding one of the public methods of java.lang.Object, that also
 * does not count toward the interface’s abstract method count since any implementation of the interface will have an
 * implementation from java.lang.Object or elsewhere. e.g. Comparator is a functional interface even though it declared
 * two abstract methods. Why? Because one of these abstract methods  “equals()” which has signature equal to public
 * method in Object class.
 */

@FunctionalInterface
public interface FunctionalInterfaceDemo {
    void hello();

    default void doSomeMoreWork1() {
        //Method body
    }

    default void doSomeMoreWork2() {
        //Method body
    }

    @Override
    boolean equals(Object obj);        //Overridden from Object class


    @Override
    String toString();        //Overridden from Object class
}
