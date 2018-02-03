package knowledge;

/**
 * 
 * @author weiyan.xiang
 * @date 3 Feb 2018
 */
public class PassByValueDemo {

    private int value = 0;

    public class TestPoint {

        private String name;

        /**
         * @param name
         */
        public TestPoint(String name) {
            this.name = name;
        }

    }

    public void increase(int input) {
        value = input;
    }

    public static void main(String[] args) {
        PassByValueDemo instance = new PassByValueDemo();
        instance.increase(3);
        System.out.println(instance.value);

        /*
         * pass by value example
         */
        TestPoint tp1 = instance.new TestPoint("TP1");
        TestPoint tp2 = instance.new TestPoint("TP2");
        System.out.println("Before badbadSwap, tp1 => " + tp1.name);
        System.out.println("Before badSwap, tp2 => " + tp2.name);
        badSwap(tp1, tp2);
        System.out.println("After badSwap, tp1 => " + tp1.name);
        System.out.println("After badSwap, tp2 => " + tp2.name);

    }

    public static void badSwap(TestPoint tp1, TestPoint tp2) {
        TestPoint temp = tp1;
        tp1 = tp2;
        tp2 = temp;
    }

}
