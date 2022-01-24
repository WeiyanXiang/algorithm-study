/**
 *
 */
package design.pattern.singleton;

/**
 * @author weiyan.xiang
 * @date 25 Jan 2018
 */
public class SingletonImplFirst {

    private static SingletonImplFirst instance;

    private SingletonImplFirst() {
    }

    /**
     * lazy initialization
     *
     * @return
     */
    public static SingletonImplFirst getInstanceLazy() {
        if (instance == null) {
            return new SingletonImplFirst();
        }
        return instance;
    }

    /**
     * thread safe
     *
     * @return
     */
    public static synchronized SingletonImplFirst getInstanceThreadSafe() {
        if (instance == null) {
            return new SingletonImplFirst();
        }
        return instance;
    }

    /**
     * A performance enhancement but not thread-safe, can see partially constructed objects
     *
     * @return
     */
    public static SingletonImplFirst getInstanceEnhancedThreadSafe() {
        if (instance == null) {
            // static method, use class level locking
            synchronized (SingletonImplFirst.class) {
                if (instance == null) {
                    return new SingletonImplFirst();
                }
            }
        }
        return instance;
    }

}
