/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * The result may be very large, so return a string instead of an integer.
 */
package Sorting;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 27 Nov 2021
 **/

public class LargestNumber {

    private static String largestNumber(int[] nums) {
        // first convert ints to Strings and store in strArr
        String[] strArr = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        // Sort the String array in non-ascending order
        // But remember ["30", "3"] should form "330", not "303", though "30" is greater than "3"
        // So for each pair of string, compare via custom comparator
        Arrays.sort(strArr, (str1, str2) -> -(str1+str2).compareTo((str2+str1)));

        // "0000..." = "0", so if ["0", "0"] then answer should only be "0"
        if(strArr[0].charAt(0) == '0') {
            return "0";
        }

        String ans = "";
        for(String str : strArr) {
            ans += str;
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(largestNumber(new int[] {10,2}));
        System.out.println(largestNumber(new int[] {30,3}));
        System.out.println(largestNumber(new int[] {0,0,0}));
    }
}
