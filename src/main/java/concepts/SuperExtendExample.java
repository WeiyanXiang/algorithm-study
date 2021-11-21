package concepts;

/**
 * @author Weiyan Xiang on 2021/11/21
 */

public class SuperExtendExample extends SuperExample {
    private int z;

    public SuperExtendExample(int x, int y, int z) {
        super(x, y);
        // as long as one super constructor called
        // super(x);
        this.z = z;
    }

    @Override
    public void func() {
        // unlike constructor, optional to call super's method
        super.func();
        System.out.println("SuperExtendExample.func()");
    }

    public static void main(String[] args) {
        SuperExample e = new SuperExtendExample(1, 2, 3);
        e.func();
    }
}
