package knowledge;

/**
 * 
 * @author weiyan.xiang
 * @date 3 Feb 2018
 */
public class PassByValueDemo {

    private int value = 0;

    public void increase(int input) {
        value = input;
    }

    public static void main(String[] args) {
        PassByValueDemo instance = new PassByValueDemo();
        instance.increase(3);
        System.out.println(instance.value);
    }

}
