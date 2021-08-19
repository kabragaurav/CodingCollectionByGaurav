/**
 * Amazon
 * Given an array of integers, nums, sort the array in any manner such that when i is even,
 * nums[i] is even and when i is odd, nums[i] is odd.
 * A valid sorting of nums will always exist.
 */
package Sorting;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 19 August 2021
 **/

public class SortByOddEven {
    private static int[] sortArrayByOddEven(int[] nums) {
        /**
         * Logic:
         * Create two arrays, even and odd. They hold even and odd numbers from nums, respectively.
         * After creating and populating them, just put back element alternatively from even and odd to nums.
         *
         * Time Complexity : O(N) due to nums iteration and re-populating it
         * Space Complexity : O(N) due to even and odd arrays
         */
        int N = nums.length;
        int[] even = new int[N/2];
        int[] odd = new int[N/2];

        int i = -1, j = -1;
        for(int k=0; k<N; k++) {
            if((nums[k] & 1) == 0) {
                even[++i] = nums[k];
            } else {
                odd[++j] = nums[k];
            }
        }
        i = 0;
        j = 0;
        for(int k=0; k<N; k++) {
            if((k&1) == 0) {
                nums[k] = even[i++];
            } else {
                nums[k] = odd[j++];
            }
        }
        return nums;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        Arrays.stream(sortArrayByOddEven(new int[]{4,2,5,7}))
                .forEach(x -> System.out.println(x));
        Arrays.stream(sortArrayByOddEven(new int[]{2,3}))
                .forEach(x -> System.out.println(x));
        Arrays.stream(sortArrayByOddEven(new int[]{3,2}))
                .forEach(x -> System.out.println(x));
    }
}
