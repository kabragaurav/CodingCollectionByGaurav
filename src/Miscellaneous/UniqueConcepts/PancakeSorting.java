/**
 * Given an array of integers arr:
 *
 *     Write a function flip(arr, k) that reverses the order of the first k elements in the array arr.
 *     Write a function pancakeSort(arr) that sorts and returns the input array. You are allowed to use
 *     only the function flip you wrote in the first step in order to make changes in the array.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gkabra
 * @since 13-03-2022 Sun
 **/

import java.util.Arrays;

public class PancakeSorting {

    // TC : O(N^2)
    // SC : O(1)
    // Visualization : https://tinyurl.com/pancake-sorting
    private static int[] pancakeSort(int[] arr) {
        int N = arr.length;

        int start = 0;
        int end = N-1;
        int k = N;

        while(k > 0) {
            int maxIndex = getMax(arr, start, end);
            int temp = arr[start];
            arr[start] = arr[maxIndex];
            arr[maxIndex] = temp;
            flip(arr, k);
            k--;
            end--;
        }

        return arr;
    }

    private static int getMax(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=start; i<=end; i++) {
            if(max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static void flip(int[] arr, int k) {
        int i = 0;
        int j = k-1;
        while(i <= j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(Arrays.toString(pancakeSort(new int[] {1, 5, 2, 3, 2})));
        System.out.println(Arrays.toString(pancakeSort(new int[] {1, 5, 2, 3, 4})));
    }

}
