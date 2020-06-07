package finance.montecarlo;

/**
 * @author Weiyan Xiang on 2020/6/7
 */
public class estimatePi {

    public static double estimate(int n) {
        int inside = 0;
        for (int i = 0; i < n; i++) {
            double x = Math.random();
            double y = Math.random();
            if (x * x + y * y <= 1) inside++;
        }
        return ((double) inside / n) * 4;
    }

    public static void main(String[] args) {
        System.out.println(estimate(3000));
        System.out.println(estimate(30000));
        System.out.println(estimate(300000));
        System.out.println(estimate(3000000));
    }
}
