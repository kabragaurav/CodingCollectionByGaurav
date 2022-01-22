/**
 * Pramp
 * You are given 2 numbers (x , n); the task is to find n√x (nth root of x).
 * Answer should be within error of 0.001.
 */
package Searching;

/**
 * @author gkabra
 * @since 22-01-2022 Sat
 **/

public class NthRoot {

    // TC : O(logx)
    // SC : O(1)
    private static double nThRoot(double x, double n) {
        double left = 0;
        double right = x;
        double mid = left + (right-left)/2;

        /**
         * since lowerBound<root<upperBound, then the true error |root-approxRoot|,
         * satisfies |root-approxRoot| < (approxRoot - lowerBound)
         * so it is indeed enough to check when the value on the right side is lower than 0.001
         */
        while(mid-left >= 0.001) {
            if(Math.pow(mid, n) > x) {
                right = mid;
            } else if(Math.pow(mid, n) < x) {
                left = mid;
            } else {
                return mid;
            }
            mid = left + (right-left)/2;        // order matters E.g. (27, 3)
        }
        return mid;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(nThRoot(9,2));
        System.out.println(nThRoot(7,3));
        System.out.println(nThRoot(27,3));

    }

}
