package concepts;

/**
 * @author Weiyan Xiang on 2021/11/21
 */

public class SuperExample {
    protected int x;
    protected int y;

    public SuperExample(int x) {
        this.x = x;
    }

    public SuperExample(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void func() {
        System.out.println("SuperExample.func()");
    }
}
