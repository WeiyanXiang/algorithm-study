/**
 *
 */
package design.pattern.singleton;


/**
 * Thread-Safe in the sense of static field with new instance, many thread can access, single instance created
 */
public class SingletonImplFifth {

    private static final SingletonImplFifth INSTANCE = new SingletonImplFifth();

    // to defend public constructor
    private SingletonImplFifth() {
    }

    /**
     * If your singleton class is not using a lot of resources, this is the approach to use. But in most of the
     * scenarios, Singleton classes are created for resources such as File System, Database connections etc and we
     * should avoid the instantiation until unless client calls the getInstance method. Also this method doesn�t provide
     * any options for exception handling.
     */
    public SingletonImplFifth getInstance() {
        return INSTANCE;
    }
}
