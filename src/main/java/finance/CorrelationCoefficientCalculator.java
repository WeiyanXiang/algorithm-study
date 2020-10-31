package finance;

import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

/**
 * @author Weiyan Xiang on 2020/9/24
 */
public class CorrelationCoefficientCalculator {

    public static void main(String[] args) {
        double[] x = {0.021, 0.035, -0.046, 0.001, 0.044, -0.029, -0.026, -0.029,
                0.048, -0.006, -0.036, -0.011, 0.019, -0.027, 0.026};
        double[] y = {0.029, 0.020, -0.044, 0.008, 0.026, -0.019, -0.010, -0.007,
                0.043, 0.011, -0.036, -0.018, 0.009, -0.032, 0.023};

        calcCorrelationCoefficient(x, y);
    }

    private static double calcCorrelationCoefficient(double[] x, double[] y) {
        double covariance = calcCovariance(x, y);
        double sd1 = calcStandardDeviation(x);
        double sd2 = calcStandardDeviation(y);
        double cc = covariance / (sd1 * sd2);
        System.out.println("Correlation Coefficient is: " + cc);
        return cc;
    }


    private static double calcCovariance(double[] x, double[] y) {
        Covariance c = new Covariance();
        double covariance = c.covariance(x, y);
        System.out.println("covariance of the two datasets is: " + covariance);
        return covariance;


    }

    private static double calcStandardDeviation(double[] x) {
        StandardDeviation s = new StandardDeviation();
        double sd = s.evaluate(x);
        System.out.println("Standard Deviation of dataset is: " + sd);
        return sd;
    }

}
