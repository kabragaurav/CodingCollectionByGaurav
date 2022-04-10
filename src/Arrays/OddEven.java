/*
Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.
 */
package Arrays;

import Arrays.Utils.ArrayUtils;

/**
 * @author gaurav kabra
 * @since 10/Apr/2022
 **/

public class OddEven {

    // TC : O(N)
    // SC : O(1)
    private static int[] sortArrayByOddEven(int[] nums) {
        int N = nums.length;
        int even = 0;
        int odd = N-1;

        while (even < N && odd >= 0) {
            if (nums[even] % 2 == 0) {
                even += 2;
            }
            if (nums[odd] % 2 == 1) {
                odd -= 2;
            }
            if (even < N && odd >= 0 && nums[even] % 2 == 1 && nums[odd] % 2 == 0) {
                int t = nums[even];
                nums[even] = nums[odd];
                nums[odd] = t;
            }
        }
        return nums;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        ArrayUtils.printArray(sortArrayByOddEven(new int[] {4,2,5,7}));
    }

}
