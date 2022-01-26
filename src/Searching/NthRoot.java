/**
 * Pramp
 * You are given 2 numbers (x , n); the task is to find n√x (nth root of x).
 * Answer should be within error of 0.001.
 *
 * Coded by peer in C++
 *
 *     #include <iostream>
 *     using namespace std;
 *
 *     double root(double x, unsigned int n)
 *     {
 *         double low = 0, high = x;
 *
 *         while(low <= high) {
 *             double mid = low + (high-low)/2.0;
 *             double midN = 1;
 *
 *             for(int i = 1; i <= n; ++i) {
 *                 midN *= mid;
 *             }
 *
 *             if(midN <= x+0.001 && midN >= x-0.001) {
 *                 return mid;
 *             } else if (midN < x) {
 *                 low = mid;
 *             } else {
 *                 high = mid;
 *             }
 *         }
 *         return low;      // due to while loop, low=high=mid
 *     }
 *
 *     int main() {
 *         return 0;
 *     }
 *
 *
 *     /**
 *      Discussions during interview
 *
 *      ans = 7^(1/3)
 *      log(ans) = 1/3  * log(7)
 *
 *
 *      0.001, 0.002,
 *
 *
 *      0, x
 *
 *      mid = (o+x)/2
 *
 *      8, 3
 *      1+1
 *      low = 0
 *      high = 4
 *      mid = 4
 *
 *      My explanation on TC
 *
 *      eps = 0.001
 *
 *      eps = 0.1
 *
 *      x = 27 n= 3
 *
 *
 *      0 to 27 search space
 *      0, 0.1, 0.2..1
 *      0-1
 *      1-2
 *
 *      26-27
 *      0.01
 *
 *      O(log(10^3 * M)) *  O(logN)
 *      Math.pow()  -> O(1)
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
