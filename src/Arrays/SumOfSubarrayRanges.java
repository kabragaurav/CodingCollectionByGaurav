/**
 * You are given an integer array nums.
 * The range of a subarray of nums is the difference between the largest and
 * smallest element in the subarray.
 * Return the sum of all subarray ranges of nums.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
package Arrays;

/**
 * @author gkabra
 * @since 20-02-2022 Sun
 **/

public class SumOfSubarrayRanges {

    // TC : O(N^2)
    // SC : O(1)
    private static long subArrayRanges(int[] nums) {
        int N = nums.length;
        long sum = 0;
        int max, min;
        for(int i=0; i<N; i++) {
            max = min = nums[i];
            for(int j=i; j<N; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                sum += (max - min);
            }
        }
        return sum;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(subArrayRanges(new int[] {1,2,3}));
    }

}
