/**
 * Given an array digits (length <= 100) that represents a non-negative integer,
 * add one to the number and return the result as an array.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 21 Oct 2021
 **/

import java.util.Arrays;

public class PlusOne {

    /**
     * Logic:
     * We start adding 1 to the number.
     * if the number is < 9 then we simply add 1 (i.e. increment it by 1)
     * else we set it to 0 (since 9 + 1 = 10, 0 is result and 1 is carry)
     *
     * At last if first digit is 0, that means last result was either 10 or the number itself is 0.
     * So we incorporate 1 as carry.
     *
     * TC : O(N)
     * SC : O(1)
     */
    private static int[] plusOneEfficient(int[] digits) {
        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if(digits[0] == 0) {
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }

    /**
     * Logic:
     * We maintain a carry to store carry of addition.
     * And keep addign result to a string s.
     * At last we read s from right to left and return result.
     *
     * TC : O(N)
     * SC : O(N)
     */
    private static int[] plusOneIntuitive(int[] digits) {
        int carry = 0;
        String s = "";
        int sum = digits[digits.length-1] + 1;
        if(sum >= 10) {
            carry = 1;
            sum -= 10;
        }
        s += sum;
        for(int i=digits.length-2; i>=0; i--) {
            sum = digits[i] + carry;
            if(sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            s += sum;
        }

        if(carry == 1) {
            s += 1;
        }

        int[] ans = new int[s.length()];
        for(int i=s.length()-1; i>=0; i--) {
            ans[s.length()-1-i] = s.charAt(i)-'0';
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(Arrays.toString(plusOneEfficient(new int[] {1,2,3})));
        System.out.println(Arrays.toString(plusOneIntuitive(new int[] {1,2,3})));

        System.out.println(Arrays.toString(plusOneEfficient(new int[] {9,9})));
        System.out.println(Arrays.toString(plusOneIntuitive(new int[] {9,9})));
    }
}
