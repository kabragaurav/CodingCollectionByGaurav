/**
 * Given an sorted integer array, nums, that has been rotated at an unknown index,
 * return the minimum value.
 * The array only contains unique values.
 */
package Searching;

/**
 * @author gaurav kabra
 * @since 5 Nov 2021
 **/

public class MinInRotatedSortedArr {
    private static int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        if(nums[right] >= nums[left]) {
            return nums[left];
        }
        while(left <= right) {
            int mid = left + (right-left)/2;
            // first check this. E.g. [11,13]
            if(nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            // then have this check. If this check is before, then ArrayIndexOutOfBounds Exception.
            if(nums[mid-1] > nums[mid]) {
                return nums[mid];
            }
            if(nums[mid] > nums[0]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {1}));
        System.out.println(findMin(new int[] {11,13,15,17}));
        System.out.println(findMin(new int[] {15,17,11,13}));
    }
}
