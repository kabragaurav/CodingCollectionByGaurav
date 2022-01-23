/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the
 * left of the index is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because
 * there are no elements to the left. This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 */

package Miscellaneous.UniqueConcepts;

import java.util.stream.IntStream;
import java.util.Arrays;

/**
 * @author gkabra
 * @since 23-01-2022 Sun
 **/

public class PivotElementPrefixSum {

    // TC : O(N)
    // SC : O(1)
    // Logic: Reframe of MiddleIndex.java
    private static int pivotIndex(int[] nums) {
        int N = nums.length;
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;

        for(int i=0; i<N; i++) {
            if(leftSum == sum-leftSum-nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(pivotIndex(new int[] {-1,-1,0,1,1,-1}));
    }

}
