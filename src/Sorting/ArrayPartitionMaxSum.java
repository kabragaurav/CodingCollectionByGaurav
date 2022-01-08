/**
 * Given an integer array nums of 2n integers, group these integers into n pairs
 * (a1, b1), (a2, b2), ..., (an, bn)
 * such that the sum of min(ai, bi) for all i is maximized.
 * Return the maximized sum.
 */
package Sorting;

/**
 * @author gaurav kabra
 * @since 08 Jan 2022
 **/

import java.util.Arrays;

public class ArrayPartitionMaxSum {

    /**
     * Logic:
     * Though intuitive, a rough proof is provided here with excellent explanation:
     * https://tinyurl.com/ArrayPartitionMaxSum
     *
     * TC : O(NlogN) due to sort + O(N) due to a traversal. So O(NlogN) overall.
     * SC : O(1)
     */
    private static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(arrayPairSum(new int[] {1,4,3,2}));
    }
}
