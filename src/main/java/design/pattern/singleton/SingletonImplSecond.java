/**
 * 
 */
package design.pattern.singleton;

/**
 * @author weiyan.xiang
 * @date 25 Jan 2018
 */
public class SingletonImplSecond {

    public static final SingletonImplSecond INSTANCE = new SingletonImplSecond();

    private SingletonImplSecond() {
        // Exists only to defeat instantiation.
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
