/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
Find the kth positive integer that is missing from this array.
 */
package Searching;

/**
 * @author gaurav kabra
 * @since 01/Apr/2022
 **/

public class KthMissingNumber {

    // TC : O(N)
    // SC : O(1)
    private static int findKthPositiveLinearSearch(int[] arr, int k) {
        int count = 0;
        int ptr = 0;
        int i = 1;
        for (; ptr < arr.length; i++) {
            if (arr[ptr] == i) {
                ptr++;
            } else {
                count++;
            }
            if (count == k) {
                return i;
            }
        }

        i--;

        while (count < k) {
            i++;
            count++;
        }
        return i;
    }

    // TC : O(logN)
    // SC : O(1)
    private static int findKthPositiveBinarySearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;

        while (left <= right) {
            int mid = left + (right-left)/2;

            // the number of missings under A[mid] is A[mid] - 1 - mid
            if (arr[mid]-1-mid < k) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        // the kth positive number will be left + k
        return left + k;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(findKthPositiveLinearSearch(new int[] {2,3,4,7,11}, 5));
        System.out.println(findKthPositiveLinearSearch(new int[] {1,2,3,4}, 2));

        System.out.println(findKthPositiveBinarySearch(new int[] {2,3,4,7,11}, 5));
        System.out.println(findKthPositiveBinarySearch(new int[] {1,2,3,4}, 2));
    }

}
