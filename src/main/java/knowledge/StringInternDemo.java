/**
 * 
 */
package knowledge;

/**
 * @author weiyan.xiang
 * @date 11 Feb 2018
 */
public class StringInternDemo {
    private String name1;
    private String name2;

    /**
     * @param name1
     * @param name2
     */
    public StringInternDemo(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public static void main(String[] args) {
        String s3 = "name";
        StringInternDemo instance = new StringInternDemo("name", "name");
        System.out.println(instance.name1 == instance.name2);
        System.out.println(instance.name1 == s3);
        System.out.println(instance.name1.equals(instance.name2));
        System.out.println(instance.name1.equals(s3));

        System.out.println(instance.name1.intern() == s3.intern());
        System.out.println(instance.name1.intern() == instance.name2.intern());
        System.out.println();
        System.out.println(new String("123") == new String("123"));
        System.out.println(new String("123").equals(new String("123")));
        System.out.println(new String("123").intern() == new String("123").intern());
    }

}
