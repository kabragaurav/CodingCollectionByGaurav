/**
 * Given an integer array nums, return the minimum number of moves required to make all array elements equal.
 * In one move, you can **increment or decrement an element of the array by 1**.
 *
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 */
package Mathematical;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 23 Nov 2021
 **/

public class MinMovesToEqqualArray_II {

    // Logic - https://tinyurl.com/min-moves-equal-arr-2
    // TC: O(NlogN)
    // SC: O(1)
    private static int minMoves_ii(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int median = (N%2 == 1 ? nums[N/2] : (nums[N/2-1] + nums[N/2])/2);

        int moves = 0;
        for(int num : nums) {
            moves += Math.abs(num-median);
        }
        return moves;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(minMoves_ii(new int[] {1,2,3}));
    }
}
