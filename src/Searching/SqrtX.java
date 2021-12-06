/**
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated,
 * and only the integer part of the result is returned.
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */
package Searching;

/**
 * @author gaurav kabra
 * @since Dec 6, 2021
 **/

public class SqrtX {

    // We don't use Math.sqrt(). Instead use simple binary search
    private static int mySqrt(int x) {
        long start = 0;
        long end = x;

        while(start <= end) {
            long mid = start + (end-start)/2;

            if(mid*mid == x) {
                return (int) mid;
            } else if(mid*mid > x) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return (int) end;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(mySqrt(2147395599));

    }
}
