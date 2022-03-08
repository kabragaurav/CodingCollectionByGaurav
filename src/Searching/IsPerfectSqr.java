/**
 * Given a positive integer num, write a function which returns True if num is a perfect
 * square else False.
 * Do not use any built-in library function such as sqrt.
 *
 * 1 <= num <= 2^31 - 1
 */
package Searching;

/**
 * @author gkabra
 * @since 08-03-2022 Tue
 **/

public class IsPerfectSqr {

    // TC : O(log(num))
    // SC : O(1)
    private static boolean isPerfectSquare(int num) {
        long left = 1;          // long if num exceeds Integer.MAX_VALUE
        long right = num;

        while(left <= right) {
            long mid = left + (right-left)/2;

            long mulMid = mid * mid;

            if(mulMid == num) {
                return true;
            } else if (mulMid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(18));
    }

}
