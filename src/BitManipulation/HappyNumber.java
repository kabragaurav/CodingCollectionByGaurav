/**
 * Given an integer n, return whether it is a "happy" number. A magical number is an integer such
 * that when you repeatedly replace the number with the sum of the squares of its digits, it eventually becomes one.
 */
package BitManipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gaurav kabra
 * @since 7 Oct 2021
 **/

public class HappyNumber {

    // Gets sum of square of digits in a number n
    private static int getSumOfSqr(int n) {
        int sum = 0;
        while(n>0) {
            int digit = n%10;
            sum += (digit*digit);
            n /= 10;
        }
        return sum;
    }

    /*
        Logic:
        We try to reduce number to n by replacing it with sum of squares of its number.
        If it happens, we return true.
        Else we keep adding every value of n into a set and if it repeats, we know it is infinite loop. So return false
        TC: O(logN) since checking if a number if in set takes O(1) time and processing each digit in a number takes O(logN) time since each number has logN digits.
        SC: O(logN), closely related to TC.
      */
    private static boolean isHappy(int n) {
        Set<Integer> st = new HashSet<>();
        while(n != 1) {
            n = getSumOfSqr(n);
            if(st.contains(n)) {
                return false;
            } else {
                st.add(n);
            }
        }
        return true;
    }
    
    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(isHappy(91));
        System.out.println(isHappy(1));
        System.out.println(isHappy(2));
        System.out.println(isHappy(7));
    }
}
