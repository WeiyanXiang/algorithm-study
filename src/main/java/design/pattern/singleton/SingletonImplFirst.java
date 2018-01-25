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
     * A performance enhancement but not thread-safe
     * 
     * @return
     */
    public static SingletonImplFirst getInstanceEnhancedThreadSafe() {
        synchronized (SingletonImplFirst.class) {
            if (instance == null) {
                return new SingletonImplFirst();
            }
            return instance;
        }
    }

}
