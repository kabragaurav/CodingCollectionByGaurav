/**
 * Given the array nums (length <= 100), for each nums[i] find out how many numbers in
 * the array are smaller than it. That is, for each nums[i] you have to count the
 * number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 */
package Arrays;

import Arrays.Utils.ArrayUtils;

/**
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class NumberSmallerThanCurrentNumber {

    // TC : O(N)
    // SC : O(N)
    private static int[] smallerNumbersThanCurrent(int[] nums) {
        int N = nums.length;
        int[] count = new int[101];

        // get freq of each number
        for(int num : nums) {
            count[num]++;
        }

        // running sum to know for each element how many numbers are smaller
        int[] sum = new int[101];
        for(int i=1; i<101; i++) {
            sum[i] += count[i-1] + sum[i-1];
        }

        int[] ans = new int[N];
        for(int i=0; i<N; i++) {
            ans[i] = sum[nums[i]];
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        ArrayUtils.printArray(smallerNumbersThanCurrent(new int[] {8,1,2,2,3}));
    }

}
