/*
Given an array nums, return true if the array was originally sorted in non-decreasing order,
then rotated some number of positions (including zero). Otherwise, return false.
There may be duplicates in the original array.
 */
package Arrays;

/**
 * @author gaurav kabra
 * @since 07/May/2022
 **/

public class IsArraySortedButRotated {

    /*
        TC : O(N)
        SC : O(1)

        Compare all neignbour elements (a,b) in A,
        The case of a > b can happen at most once.
        The first element and the last element are also connected.
     */

    private static boolean check(int[] nums) {
        int N = nums.length;
        int prevGreater = 0;

        for (int i=0; i<N; i++) {
            if (nums[i] > nums[(i+1) % N]) {
                prevGreater++;
                if (prevGreater > 1) {
                    return false;
                }
            }
        }

        return prevGreater <= 1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(check(new int[] {2,1,3,4}));
        System.out.println(check(new int[] {1,2,3,4,5}));
        System.out.println(check(new int[] {3,4,1,2}));
    }

}
