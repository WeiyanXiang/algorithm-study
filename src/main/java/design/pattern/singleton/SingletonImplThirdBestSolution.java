/**
 *
 */
package design.pattern.singleton;

/**
 * @author weiyan.xiang
 * @date 1 Feb 2018
 */
public class SingletonImplThirdBestSolution {

    // to defend public constructor
    private SingletonImplThirdBestSolution() {
    }

    private static class SingletonHelper {
        private final static SingletonImplThirdBestSolution INSTANCE = new SingletonImplThirdBestSolution();
    }

    /**
     * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
     *
     * Notice the private inner static class that contains the instance of the
     * singleton class. When the singleton class is loaded, SingletonHelper
     * class is not loaded into memory and only when someone calls the
     * getInstance method, this class gets loaded and creates the Singleton
     * class instance. This is the most widely used approach for Singleton class
     * as it doesn�t require synchronization.
     */

    /**
     * the reason why when call SingletonHelper.INSTANCE the innerclass field instance will be created is because:
     * https://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class
     * <p>
     * Nested classes are divided into two categories: static and non-static. Nested classes that are declared static
     * are simply called static nested classes. Non-static nested classes are called inner classes.
     *
     * @return
     */
    public static SingletonImplThirdBestSolution getInstance() {
        return SingletonImplThirdBestSolution.SingletonHelper.INSTANCE;
    }

}
