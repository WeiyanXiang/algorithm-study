package knowledge;

/**
 * @author weiyan.xiang
 * @date 3 Feb 2018
 */
public class PassByValueDemo {

    private int value = 0;

    class TestPoint {

        private String name;

        /**
         * @param name
         */
        public TestPoint(String name) {
            this.name = name;
        }

    }

    /*
     * this method demonstrate pass reference By Value and altering the end
     * object will be reflected to actual object
     */
    public void increase(int input) {
        value = input;
    }

    public static void main(String[] args) {
        PassByValueDemo instance = new PassByValueDemo();
        instance.increase(3);
        System.out.println(instance.value);

        /*
         * pass by value example
         *
         */
        TestPoint tp1 = instance.new TestPoint("tp1");
        TestPoint tp2 = instance.new TestPoint("tp2");
        System.out.println("Before badSwap, tp1 => " + tp1.name);
        System.out.println("Before badSwap, tp2 => " + tp2.name);
        badSwap(tp1, tp2);
        System.out.println("After badSwap, tp1 => " + tp1.name);
        System.out.println("After badSwap, tp2 => " + tp2.name);

        /**
         * Because pass by value means a copy of reference passed to method but
         * it points to the original object, so swap will fail because the
         * copies of ref swapped, the original refs are still same. But Object
         * altering happened because the ref points to the actual object
         */
        TestPoint tp3 = instance.new TestPoint("tp3");
        TestPoint tp4 = instance.new TestPoint("tp4");
        System.out.println("Before trickySwap, tp3 => " + tp3.name);
        System.out.println("Before trickySwap, tp4 => " + tp4.name);
        trickySwap(tp3, tp4);
        System.out.println("After trickySwap, tp3 => " + tp3.name);
        System.out.println("After trickySwap, tp4 => " + tp4.name);

    }

    public static void badSwap(TestPoint tp1, TestPoint tp2) {
        TestPoint temp = tp1;
        tp1 = tp2;
        tp2 = temp;
    }

    public static void trickySwap(TestPoint input1, TestPoint input2) {
        input1.name = "INPUT3";
        input2.name = "INPUT4";
        TestPoint temp = input1;
        input1 = input2;
        input2 = temp;
    }

}
