/**
 * Given an array nums which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.
 */
package Searching;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 19-01-2022 Wed
 **/

public class SplitArrayLargestSum {

    private static boolean feasible(int[] nums, int mid, int m) {
        int mDone = 1;
        int idx = 0;
        int sumSoFar = 0;
        while(idx < nums.length) {
            sumSoFar += nums[idx];
            if(sumSoFar > mid) {        // then enough in this partition. We move to next partition
                mDone++;
                sumSoFar = nums[idx];
                if(mDone > m) {
                    return false;
                }
            }
            idx++;
        }
        return true;
    }

    /**
     * Solution is same as ShipPackagesInDDays.java
     *
     * Logic:
     * we can design a feasible function: given an input threshold (mid), decide if we can split the array
     * into m subarrays such that every subarray-sum is less than or equal to threshold. In this way, we discover
     * if feasible() is True, then all inputs larger than mid can satisfy feasible function.
     */
    private static int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();

        while(left < right) {
            int mid = left + (right-left)/2;
            if(feasible(nums, mid, m)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(splitArray(new int[] {7,2,5,10,8}, 2));   // split as [7,2,5] and [10,8]
        System.out.println(splitArray(new int[] {1,2,3,4,5}, 2));
        System.out.println(splitArray(new int[] {1,4,4}, 3));
    }

}
