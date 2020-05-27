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

    public SingletonImplFifth getInstance() {
        return INSTANCE;
    }
}
