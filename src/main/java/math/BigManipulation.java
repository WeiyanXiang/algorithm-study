package math;

/**
 * @author Weiyan Xiang on 2020/5/20
 */
public class BigManipulation {

    public static void main(String[] args) {
        /**
         * 5 << 3 = 40: That shows that shifting a number by one is equivalent to multiplying it by 2, or more
         * generally left shifting a number by n positions is equivalent to multiplication by 2n.
         */
        System.out.println((6 >> 1) + " = 3");
        System.out.println((5 << 4) + " = 80");
        System.out.println((5 << 1) + " = 10");
        System.out.println((3 << 2) + " = 12");
    }
}
