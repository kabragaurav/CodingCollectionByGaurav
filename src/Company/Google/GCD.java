/*
Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 */
package Company.Google;

/**
 * @author gaurav kabra
 * @since 21/Apr/2022
 **/

public class GCD {
    private static int findGCD(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;

        for (int num : nums) {
            a = Math.min(a, num);
            b = Math.max(b, num);
        }

        return gcd(a, b);           // order of passing does not matter
    }

    // TC : O(log(max(a, b)))
    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a-b, b);
        }
        return gcd(a, b-a);
    }
    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(findGCD(new int[] {2,5,6,9,10}));
        System.out.println(findGCD(new int[] {7,5,6,8,3}));
    }

}
