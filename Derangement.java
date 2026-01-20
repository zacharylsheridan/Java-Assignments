/**
 * Implementations for a naive alogorithm and a fast algorithm that 
 * count the number of derangements of a set given its cardinality.
 * @author William Duncan, Zachary Sheridan
 * <pre>
 * Date: 9-9-2024
 * Course: CSC 3102 Section 1
 * Project # 0
 * Instructor: Dr. Duncan
 * </pre>
 */

public class Derangement {
    /**
     * Computes the number of derangements of a set
     *
     * @param n the size of the set
     * @return the number of derangements of a set with the specified size
     * @throws IllegalArgumentException exception when n is negative
     */
    public static double fastDerange(int n) {
        double delta = 0.00;
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater than zero!");
        } else if (n == 0) {
            return 1;
        } else {
            double term = -1;
            double sum = 0;
            for (int i = 2; i <= n; i++) {
                term = -term / i;
                sum = sum + term;
            }
            delta = sum/Math.abs(term);
        }
        return delta;
    }

    /**
     * Computes the number of derangements of a set
     *
     * @param n the size of the set
     * @return the number of derangements of a set with the specified size
     * @throws IllegalArgumentException exception when n is negative
     */
    public static double naiveDerange(int n) {
        double delta, factRcp = 0.0;
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater than zero!");
        } else if (n == 0) {
            return 1;
        } else {
            double sum = 0;
            double sign = -1;
            for (int i = 2; i <= n; i++) {
                sign = sign * -1;
                factRcp = 1.0;
                for (int k = 1; k <= i; k++) {
                    factRcp = factRcp / k;
                }
                sum = sum + sign * factRcp;
            }
            delta = sum / factRcp;
        }
        return delta;
    }
}
