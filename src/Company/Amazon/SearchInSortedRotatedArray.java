/**
 * Pramp
 * A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset
 * and you don’t have a pre-shifted copy of it. For instance,
 * the sequence 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2, after shifting it twice to the left.
 * Given shiftArr and an integer num, implement a function shiftedArrSearch that
 * finds and returns the index of num in shiftArr. If num isn’t in shiftArr, return -1.
 * Assume that the offset can be any value between 0 and arr.length - 1.
 * Explain your solution and analyze its time and space complexities.
 */
package Company.Amazon;

/**
 * @author gkabra
 * @since 27-01-2022 Thu
 **/

public class SearchInSortedRotatedArray {

    // TC : O(logN)
    // SC : O(1)
    private static int search(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            // can never be the case that both parts are unsorted.
            if(nums[left] <= nums[mid]) {        // check if left part sorted
                if(nums[left] <= target && target <= nums[mid]) {   // is number in this?
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {        // then right one is sorted
                if(nums[mid] <= target && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(search(new int[] {4,5,6,0,1,2,3}, 2));
        System.out.println(search(new int[] {4,5,6,0,1,3}, 2));
    }

}
