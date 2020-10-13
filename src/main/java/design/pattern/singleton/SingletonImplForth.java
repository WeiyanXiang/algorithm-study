/**
 *
 */
package design.pattern.singleton;


/**
 * Thread-Safe in the sense of static field with new instance, many thread can access, single instance created
 */
public class SingletonImplForth {

    private static final SingletonImplForth INSTANCE = new SingletonImplForth();

    // to defend public constructor
    private SingletonImplForth() {
    }

    /**
     * If your singleton class is not using a lot of resources, this is the approach to use. But in most of the
     * scenarios, Singleton classes are created for resources such as File System, Database connections etc and we
     * should avoid the instantiation until unless client calls the getInstance method. Also this method doesn�t provide
     * any options for exception handling.
     */
    public SingletonImplForth getInstance() {
        return INSTANCE;
    }
}
