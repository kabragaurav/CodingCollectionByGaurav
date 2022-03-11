/**
 * Given an array nums with n integers,
 * your task is to check if it could become non-decreasing by modifying at most one element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i
 * (0-based) such that (0 <= i <= n - 2).
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gkabra
 * @since 11-03-2022 Fri
 **/

public class NonDecreasingArray {

    /*
        TC : O(N)
        SC : O(1)
     */
    private static boolean checkPossibility(int[] nums) {
        int N = nums.length;
        int count = 0;

        for(int i=0; i<N-1; i++) {
            if(nums[i] > nums[i+1]) {
                count++;
                if(count > 1) {
                    return false;
                }
                if(i >= 1 && nums[i-1] > nums[i+1]) {
                    nums[i+1] = nums[i];
                } else {
                    nums[i] = nums[i+1];
                }
            }
        }

        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(checkPossibility(new int[] {3,4,2,3}));
        System.out.println(checkPossibility(new int[] {1,2,3}));
        System.out.println(checkPossibility(new int[] {5,7,1,8}));
    }

}
