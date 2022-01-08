/**
 * You are given an integer array nums and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value
 * and return this value.
 * Any answer with a calculation error less than 10^-5 will be accepted.
 */
package Miscellaneous.UniqueConcepts.SlidingWindow;

/**
 * @author gaurav kabra
 * @since 08 Jan 2022
 **/

public class MaxAverageSubarray {

    /**
     * Logic:
     * We traverse through a sliding window of length k, finding all subarrays of length k.
     * We find max sum among those subarray and return average by dividing by k.
     *
     * TC : O(N) due to a traversal
     * SC : O(1)
     */
    private static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int prev;
        for(int i=0; i<k; i++) {
            sum += nums[i];
        }
        prev = sum;
        for(int i=k; i<nums.length; i++) {
            // element on left is removed
            sum -= nums[i-k];
            // element on right is added
            sum += nums[i];
            prev = prev < sum ? sum : prev;
        }
        return (prev * 1.0) / k;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
    }
}
