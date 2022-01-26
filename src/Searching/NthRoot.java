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

    /**
     * Logic:
     * Since search space is monotonically increasing from 1^n to x^n. So use binary search here.
     *
     * TC : If eps is upto d decimal places (say d=1 so eps=0.1). Then between 1 to x there will be x * 10^d real numbers
     *      (here since eps=0.1 and let x=27 then 1, 1.1, 1.2, ..., 26.9, 27)
     *
     *      Math.pow() in Java is O(1)
     *      So O(1) * O(log(x10^d))
     * SC : O(1)
     *
     * Best video: https://tinyurl.com/nth-root
     */
    static double nThRoot(double x, int n) {
        // nth root of x
        double low = 1;
        double high = x;
        final double eps = 0.001;

        while(eps < high-low) {
            double mid = low + (high-low)/2;
            if(Math.pow(mid, n) < x) {
                low = mid;
            } else  {
                high = mid;
            }
        }

        return low + (high-low)/2;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(nThRoot(9,2));
        System.out.println(nThRoot(7,3));
        System.out.println(nThRoot(27,3));

    }

}
