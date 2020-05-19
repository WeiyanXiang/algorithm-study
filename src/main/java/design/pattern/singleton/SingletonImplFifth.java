/**
 *
 */
package design.pattern.singleton;


public class SingletonImplFifth {

    private static SingletonImplFifth INSTANCE;

    // to defend public constructor
    private SingletonImplFifth() {
    }

    public SingletonImplFifth getInstance() {
        return INSTANCE == null ? new SingletonImplFifth() : INSTANCE;
    }
}
