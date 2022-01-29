/**
 * Given an array, rotate the array anti-clockwise by k steps, where k is non-negative.
 */
package Company.Amazon;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 29-01-2022 Sat
 **/

public class RotateArray {

    // TC : O(N)
    // SC : O(N)
    private static void rotate(int[] nums, int k) {
        int N = nums.length;
        k = k%N;
        int[] first = Arrays.copyOfRange(nums, 0, N-k);      // i.e. N-k elements
        int[] last = Arrays.copyOfRange(nums, N-k, N);          // i.e. k elements

        for(int i=0; i<last.length; i++) {
            nums[i] = last[i];
        }

        for(int i=0; i<first.length; i++) {
            nums[last.length+i] = first[i];
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        int[] nums = new int[] {1,2,3,4,5};
        rotate(nums, 3);
        for(int num : nums) {
            System.out.println(num);
        }
    }

}
