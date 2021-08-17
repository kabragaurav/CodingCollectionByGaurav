/**
 * Apple
 * Given an array of numbers (size >= 1), move all zeroes in the array to the end
 * while maintaining the relative order of the other numbers.
 * You must modify the array you’re given (inplace operation).
 */
package Sorting;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 17 August 2021
 **/
public class MoveZeroes {
    private static void moveZeroes(int[] nums) {
        /**
         * Logic:
         * This is a variation of 2-pointer approach.
         * If size of nums is 1, no need to operate.
         * Else we keep two pointers i and j.
         * Initially i points to first non-zero number from right. And j = i-1.
         * Then we keep moving j to left and any time number at j is non-zero, we shift all numbers from [j+1, i) towards left by 1 place. And put 0 at i.
         *
         * Time Complexity : O(N^2) since iterating over numbers and shifting.
         * Space Complexity : O(1)
         */
        int N = nums.length;
        if(N == 1) {
            return;
        }
        int i = N-1, j = N-2;
        for(int k=N-1; k>=0; k--) {
            if(nums[k] != 0) {
                i = k;
                j = i-1;
                break;
            }
        }

        while(j >= 0) {
            if(nums[j] == 0) {
                if(nums[i] == 0) {              // Needed for {0,0} case where i can become -1
                    break;
                }
                for(int k=j; k<i; k++) {
                    nums[k] = nums[k+1];
                }
                nums[i] = 0;
                i--;
            } else {
                j--;
            }
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        int[] arr = {3, 7, 0, 5, 0, 2};
        moveZeroes(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();

        arr = new int[]{0, 3, 7, 5, 0, 2};
        moveZeroes(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();

        arr = new int[]{0, 0};
        moveZeroes(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }
}
