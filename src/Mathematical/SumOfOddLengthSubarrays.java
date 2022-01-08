/**
 * Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
 * A subarray is a contiguous subsequence of the array.
 * Return the sum of all odd-length subarrays of arr.
 */
package Mathematical;

/**
 * @author gaurav kabra
 * @since 08 Jan 2022
 **/

public class SumOfOddLengthSubarrays {

    /**
     * Logic:
     * https://tinyurl.com/SumOfOddLengthSubarrays
     * 
     * TC : O(N) due to a traversal
     * SC : O(1)
     */
    private static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int N = arr.length;
        for(int i=0; i<N; i++) {
            sum += ((i+1)*(N-i)+1)/2 * arr[i];
        }
        return sum;
    }
    
    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(sumOddLengthSubarrays(new int[] {1,2}));
        System.out.println(sumOddLengthSubarrays(new int[] {10,11,12}));
    }
}
