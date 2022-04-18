/*
You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length
and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 18/Apr/2022
 **/

public class MinIncrementToMakeArrUnique {

    private static final int SZ = 10000001;

    private static int minIncrementForUnique(int[] nums) {
        int[] freq = new int[SZ];

        for (int num : nums) {
            freq[num]++;
        }


        int count = 0;

        for (int i=0; i<SZ; i++) {
            if (freq[i] <= 1) {
                continue;
            }

            int diff = freq[i] - 1;
            freq[i+1] += diff;
            count += diff;
        }

        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(minIncrementForUnique(new int[] {1,2,3}));
        System.out.println(minIncrementForUnique(new int[] {1,2,2}));
        System.out.println(minIncrementForUnique(new int[] {3,2,1,2,1,7}));
    }

}
