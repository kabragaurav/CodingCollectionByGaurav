/*
Goldman Sachs
You are given an integer array nums.
In one move, you can choose one element of nums and change it by any value.

Return the minimum difference between the largest and smallest value of nums after performing at
most three moves.
 */
package Sorting;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 01/Apr/2022
 **/

public class MinDiffInThreeMoves {

    /*
        Excellent video : https://tinyurl.com/min-diff-in-3-moves

        TC : O(NlogN)
        SC : O(1)
     */
    private static int minDifference(int[] nums) {
        int N = nums.length;
        if (N <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<4; i++) {
            min = Math.min(min, nums[N-4+i]-nums[i]);
        }

        return min;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(minDifference(new int[] {5,3,2,4}));   // -> [2,2,2,2]
        System.out.println(minDifference(new int[] {1,5,0,10,14}));   // -> [1,1,0,1,1]
    }

}
