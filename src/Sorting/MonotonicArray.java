/**
 * Facebook
 * Given an array nums, return whether or not its values are monotonically
 * increasing or monotonically decreasing.
 * An array is monotonically increasing if for all values i <= j, nums[i] <= nums[j].
 * Similarly an array is monotonically decreasing if for all values i <= j, nums[i] >= nums[j].
 */
package Sorting;

/**
 * @author gaurav kabra
 * @since 20 August 2021
 **/

public class MonotonicArray {

    private static boolean isMonotonic(int[] nums) {
        /**
         * Logic:
         * If nums size is 1 then it is always monotonic (since no other element to compare to)
         * Else, first check for if it is increasing. If yes then it is monotonically increasing. Return true in this case.
         * If no, check similarly for decreasing.
         *
         * Time Complexity : O(N) due to worst case 2 passes through nums array
         * Space Complexity : O(1)
         */
        if(nums.length == 1) {
            return true;
        } else {
            boolean isIncreasing = true;
            // check for increasing
            for(int i=1; i<nums.length; i++) {
                if(nums[i] < nums[i-1]) {
                    isIncreasing = false;
                    break;
                }
            }
            if(isIncreasing) {
                return true;
            }
            // check for decreasing
            for(int i=1; i<nums.length; i++) {
                if(nums[i] > nums[i-1]) {
                    return false;
                }
            }
            return true;
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(isMonotonic(new int[] {1, 2, 3, 4, 4, 5}));
        System.out.println(isMonotonic(new int[] {7, 6, 3}));
        System.out.println(isMonotonic(new int[] {8, 4, 6}));
        System.out.println(isMonotonic(new int[] {1}));
    }
}
