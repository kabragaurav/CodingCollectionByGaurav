/**
 * Given an integer array nums, return an array where each element i
 * represents the product of all values in nums excluding nums[i].
 * Assume the product of all numbers within nums can safely fit within an integer range.
 * YOU MUST NOT USE DIVISION!
 */
package Miscellaneous.UniqueConcepts;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 4 Sept 2021
 **/

public class ProductExceptSelf {
    private static int[] productExceptSelf(int[] nums) {
        /**
         * Logic:
         * This is an amazing explanation to this problem:
         * https://tinyurl.com/product-without-self
         */
        int[] ans = new int [nums.length];

        ans[0] = 1;
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];      // calculate left products
        }

        int right = 1;
        for(int i=nums.length-1; i>=0; i--){    // calculate right products
            ans[i] = ans[i] * right;
            right *= nums[i];
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        Arrays.stream(productExceptSelf(new int[]{-1, 1, 0, -3, 3})).forEach(x -> System.out.println(x));
    }
}
