/**
 * 
 */
package design.pattern;

/**
 * @author weiyan.xiang
 * @date 25 Jan 2018
 */
public class SingletonImplSecond {

    public static final SingletonImplSecond INSTANCE = new SingletonImplSecond();

    private SingletonImplSecond() {
        // Exists only to defeat instantiation.
    }

    private static class SingletonHelper {
        private static final SingletonImplSecond BETTER_INSTANCE = new SingletonImplSecond();
    }

    /*
     * Notice the private inner static class that contains the instance of the
     * singleton class. When the singleton class is loaded, SingletonHelper
     * class is not loaded into memory and only when someone calls the
     * getInstance method, this class gets loaded and creates the Singleton
     * class instance. This is the most widely used approach for Singleton class
     * as it doesn’t require synchronization.
     */
    /**
     * the reason why when call SingletonHelper.BETTER_INSTANCE the innerclass
     * field instance will be created is because:
     * https://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class
     * 
     * instance of InnerClass can exist only within an instance of OuterClass
     * and has direct access to the methods and fields of its enclosing
     * instance.
     * 
     * To instantiate an inner class, you must first instantiate the outer
     * class. Then, create the inner object within the outer object with this
     * syntax:
     * 
     * @return
     */
    public static SingletonImplSecond getInstanceBetter() {
        return SingletonHelper.BETTER_INSTANCE;
    }

    public static void main(String[] args) {
        /**
         * to use it
         */
        /*
         * If your singleton class is not using a lot of resources, this is the
         * approach to use. But in most of the scenarios, Singleton classes are
         * created for resources such as File System, Database connections etc
         * and we should avoid the instantiation until unless client calls the
         * getInstance method. Also this method doesn’t provide any options for
         * exception handling.
         */
        SingletonImplSecond instance = SingletonImplSecond.INSTANCE;
    }

}
