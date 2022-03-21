/**
 * Given an array of integers nums, find the maximum length of a subarray where the
 * product of all its elements is positive.
 * Return the maximum length of a subarray with positive product.
 */
package Company.Amazon.Hard;

/**
 * @author gauravkabra
 * @since 21/Mar/2022
 **/

public class MaxLengthPositiveProduct {

    // TC : O(N)
    // SC : O(1)
    private static int getMaxLen(int[] nums) {
        int positive = 0;
        int negative = 0;

        int N = nums.length;
        int count = 0;

        for (int i=0; i<N; i++) {
            if (nums[i] == 0) {
                positive = 0;
                negative = 0;
            } else if (nums[i] > 0) {
                positive++;
                negative = negative == 0 ? 0 : negative + 1;
            } else {
                int temp = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = temp + 1;
            }
            count = Math.max(count, positive);
        }

        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(getMaxLen(new int[] {-1,-2,-3,0,1}));
        System.out.println(getMaxLen(new int[] {1,2,3,5,-6,4,0,10}));
    }

}
