/*
Given an array of integers and a target value.

Determine the number of distinct pairs of elements in the array that sum to the target value.

Two pairs (a, b) and (c, d) are considered to be distinct if and only if the values in sorted order do not match,
i.e., (1, 9) and (9, 1) are indistinct but (1, 9) and (9, 2) are distinct.
 */
package Company.GoMotive;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author gaurav kabra
 * @since 10/Jun/2022
 **/

public class DistinctPairsWithGivenSum {

    // TC : O(N)
    // SC : O(N)
    private static int countDistinctPairsWithGivenSum_HashMap(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            return 0;
        HashSet<Integer> nums = new HashSet<>();
        HashSet<String> seen = new HashSet<>();
        int count = 0;

        for (int num : arr) {
            int counter = target - num;
            String pair = num <= counter ? num + "_" + counter : counter + "_" + num;
            if (nums.contains(counter) && !seen.contains(pair)) {
                count++;
                seen.add(pair);
            }
            nums.add(num);
        }

        return count;
    }

    // TC : O(NlogN)
    // SC : O(1)
    private static int countDistinctPairsWithGivenSum_Sorting(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            return 0;
        Arrays.sort(arr);
        int count = 0;
        int left = 0;
        int right = arr.length - 1;

        HashSet<String> seen = new HashSet<>();

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target && !seen.contains(arr[left] + "_" + arr[right])) {
                count++;
                seen.add(arr[left] + "_" + arr[right]);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(countDistinctPairsWithGivenSum_Sorting(new int[] {1, 2, 3, 6, 7, 8, 9, 1}, 10));
        System.out.println(countDistinctPairsWithGivenSum_Sorting(new int[] {1, 2, 3, 6, 7, 8, 9, 1, 9}, 10));
        System.out.println(countDistinctPairsWithGivenSum_Sorting(new int[] {5, 6, 5, 7, 7, 8}, 13));
        System.out.println(countDistinctPairsWithGivenSum_Sorting(new int[] {2, 6, 7, 1, 8, 3}, 10));

        System.out.println(countDistinctPairsWithGivenSum_HashMap(new int[] {1, 2, 3, 6, 7, 8, 9, 1}, 10));
        System.out.println(countDistinctPairsWithGivenSum_HashMap(new int[] {1, 2, 3, 6, 7, 8, 9, 1, 9}, 10));
        System.out.println(countDistinctPairsWithGivenSum_HashMap(new int[] {5, 6, 5, 7, 7, 8}, 13));
        System.out.println(countDistinctPairsWithGivenSum_HashMap(new int[] {2, 6, 7, 1, 8, 3}, 10));
    }

}
