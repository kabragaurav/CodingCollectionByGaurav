/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 */
package Searching;

/**
 * @author gaurav kabra
 * @since 24 Oct 2021
 **/

import java.util.Arrays;
import java.util.Collections;

public class FirstAndLastIndices {

    private static int findFirstIndex(int[] nums, int target) {
        int index = -1;
        int start = 0, end = nums.length-1, mid;
        while(start <= end) {
            mid = start + (end-start)/2;
            if(nums[mid] == target) {
                index = mid;
            }
            if(nums[mid] < target) {             // this cannot be else if
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return index;
    }

    private static int findLastIndex(int[] nums, int target) {
        int index = -1;
        int start = 0, end = nums.length-1, mid;
        while(start <= end) {
            mid = start + (end-start)/2;
            if(nums[mid] == target) {
                index = mid;
            }
            if(nums[mid] <= target) {         // only difference from above method
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return index;
    }

    /**
     * Logic:
     * Apply binary search since array is sorted.
     *
     * TC : O(logN)
     * SC : O(1)
     */
    private static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirstIndex(nums, target);
        ans[1] = findLastIndex(nums, target);
        return ans;
    }

    // helper method to print int[]
    private static void print(int[] searchRange) {
        // convert int[] first to Integer[] then print
        System.out.println(Arrays.deepToString(Arrays.stream(searchRange).boxed().toArray(Integer[]::new)));
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        print(searchRange(new int[] {1,4}, 4));
        print(searchRange(new int[] {}, 0));
        print(searchRange(new int[] {1,2,2}, 2));
    }
}
