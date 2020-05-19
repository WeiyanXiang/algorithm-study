/**
 *
 */
package design.pattern.singleton;

/**
 * @author weiyan.xiang
 * @date 1 Feb 2018
 */
public class SingletonImplThird {

    // to defend public constructor
    private SingletonImplThird() {
    }

    private static class InstanceHelper {
        private final static SingletonImplThird INSTANCE = new SingletonImplThird();
    }

    /*
     * Notice the private inner static class that contains the instance of the
     * singleton class. When the singleton class is loaded, SingletonHelper
     * class is not loaded into memory and only when someone calls the
     * getInstance method, this class gets loaded and creates the Singleton
     * class instance. This is the most widely used approach for Singleton class
     * as it doesn�t require synchronization.
     */

    /**
     * the reason why when call SingletonHelper.BETTER_INSTANCE the innerclass field instance will be created is
     * because: https://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class
     * <p>
     * instance of InnerClass can exist only within an instance of OuterClass and has direct access to the methods and
     * fields of its enclosing instance.
     * <p>
     * To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within
     * the outer object with this syntax:
     *
     * @return
     */
    public static SingletonImplThird getInstance() {
        return InstanceHelper.INSTANCE;
    }

}
