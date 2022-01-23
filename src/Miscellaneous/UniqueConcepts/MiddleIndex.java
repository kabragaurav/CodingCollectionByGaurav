/**
 * Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the possible ones).
 * A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].
 * If middleIndex == 0, the left side sum is considered to be 0. Similarly, if middleIndex == nums.length - 1, the right side sum is considered to be 0.
 * Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 23 Oct 2021
 **/

public class MiddleIndex {

    /**
     * Logic:
     * One way to solve the problem is to find for each number, sum of all left elements and sum of all right elements.
     * If left sum equals right sum, return index of that number.
     * But it will be O(N) in TC (for left and right sum) and O(N) in SC (for storing sums)
     *
     * Efficient way is shown below.
     * First find sum of all elements.
     * Then check for each element if left sum (i.e., sumSoFar) = right sum (i.e., remainingSum).
     *
     * TC : O(N) due to two loops over nums, once to find total sum, once to find index
     * SC : O(1)
     */
    private static int findMiddleIndex(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        int sumSoFar = 0;

        for(int i=0; i<N; i++) {
            int remainingSum = sum - sumSoFar - nums[i];
            if(remainingSum == sumSoFar) {
                return i;
            }
            sumSoFar += nums[i];
        }
        return -1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        int[][] arrs = new int[][]{
                {2, 3, -1, 8, 4},
                {1, -1, 4},
                {2, 5},
                {1},
                {0, 0, 0, 0}
        };

        for(int[] arr : arrs) {
            System.out.println(findMiddleIndex(arr));
        }

    }
}
