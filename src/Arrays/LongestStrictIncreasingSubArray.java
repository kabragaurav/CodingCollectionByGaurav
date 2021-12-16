/**
 * Given an array containing n numbers. The problem is to find the length of the
 * longest contiguous subarray such that every
 * element in the subarray is strictly greater than its previous element in the same subarray.
 */
package Arrays;

/**
 * @author gaurav kabra
 * @since 16 Dec 2021
 **/

public class LongestStrictIncreasingSubArray {

    /**
     * We keep prev to know previous number, so as to determine if strictly increasing.
     * If not, we start from 1 again from that index onwards.
     * If yes, then we increase countSoFar.
     *
     * At last we return maximum value of countSoFar seen so far.
     *
     * TC : O(N) due to one iteration in form of the for loop
     * SC : O(1)
     */
    private static long lenOfLongIncSubArr(long arr[]) {
        int countSoFar = 0;
        long prev = Long.MIN_VALUE;
        int max = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > prev) {
                countSoFar++;
            } else {
                max = Math.max(max, countSoFar);
                countSoFar = 1;
            }
            prev = arr[i];
        }
        return Math.max(max, countSoFar);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(lenOfLongIncSubArr(new long[] {1,2,3}));
        System.out.println(lenOfLongIncSubArr(new long[] {3,2,1}));
        System.out.println(lenOfLongIncSubArr(new long[] {5,1,3}));
    }
}
