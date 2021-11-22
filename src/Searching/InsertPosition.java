/**
 * Given a sorted array of distinct integers and a target value, return the index if the target
 * is found. If not, return the index where it would be if it were inserted in order.
 */
package Searching;

/**
 * @author gaurav kabra
 * @since 22 Nov 2021
 **/

import java.util.Arrays;

public class InsertPosition {

    /**
     * Logic:
     * Arrays.binarySearch
     *          - method returns index of the search key, if it is contained in the array,
     *            else it returns (-insertion point - 1).
     *          - if the array contains multiple elements with the specified value,
     *            there is no guarantee which one will be found.
     *
     */
    private static int searchInsert(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        return idx >= 0 ? idx : -(idx + 1);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(searchInsert(new int[] {1}, 0));
        System.out.println(searchInsert(new int[] {1,2,3,4}, 2));
    }
}
