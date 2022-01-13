package concepts;

/**
 * @author Weiyan Xiang on 2022/1/11
 */

public class InnerClassExample {

    private String name;
    private static String staticName;

    private class A {
        private String nameA;

        private void foo() {
            name += "food";
        }

        // not compile, cannot have static method, is implicitly associated with outer class
        /**
         private static void bar(){
         name += "bar";
         }
         **/
    }

    public class B {
        private String nameB;
        public String sectorB;
    }

    public static class C {
        private String nameC;

        // static can only ref static vars in outer class
        public static void foo() {
            staticName += "foo";
        }
    }

    public void testFromOuter() {
        InnerClassExample example = new InnerClassExample();
        InnerClassExample.A a = new A();
        InnerClassExample.B b = new B();
        InnerClassExample.C c = new C();

        System.out.println(a.nameA);
        System.out.println(b.nameB);
        System.out.println(b.sectorB);
        System.out.println(c.nameC);
    }
}
