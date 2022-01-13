package concepts;

/**
 * @author Weiyan Xiang on 2022/1/11
 */

public class InnerClassDemo {

    public static void main(String[] args) {
        InnerClassExample example = new InnerClassExample();
        InnerClassExample.C.foo();
    }
}
