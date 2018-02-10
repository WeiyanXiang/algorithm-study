/**
 * 
 */
package design.pattern.singleton;

/**
 * @author weiyan.xiang
 * @date 10 Feb 2018
 */
public class DoubleLockedSingletonFourth {

    /*
     * very important that it is volatile becaz of the Happens-before rules
     * introduced since Java 1.5
     */
    private volatile static DoubleLockedSingletonFourth instance;

    public static DoubleLockedSingletonFourth getInstance() {
        if (instance == null) { // first part not in synchronized because of
                                // performance consideration
            synchronized (DoubleLockedSingletonFourth.class) {
                if (instance == null) {
                    return new DoubleLockedSingletonFourth();
                }
            }
        }
        return instance;
    }

}
