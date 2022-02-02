/**
 * Given an array of integers arr, return true if we can partition the array into three
 * non-empty parts with equal sums.
 *
 * Formally, we can partition the array if we can find indexes i + 1 < j with
 * (arr[0] + arr[1] + ... + arr[i] ==
 * arr[i + 1] + arr[i + 2] + ... + arr[j - 1] ==
 * arr[j] + arr[j + 1] + ... + arr[arr.length - 1])
 */
package Arrays;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 02-02-2022 Wed
 **/

public class PartitionArrayIntoThreePartsWithEqualSum {

    // TC : O(N)
    // SC : O(1)
    private static boolean canThreePartsEqualSum(int[] arr) {
        int s = Arrays.stream(arr).sum();
        if (s % 3 != 0) {
            return false;
        }
        int s1 = s/3;
        int s2 = 2*s1;

        int idx1 = -1;
        int idx2 = -1;
        int sum = 0;

        for(int i=0; i<arr.length-1; i++) {     // arr.length-1 for non empty arrays
            sum += arr[i];
            if(sum == s1 && idx1 == -1) {
                idx1 = i;
            } else if(sum == s2 && idx1 != -1) {        // remember, here also idx1
                idx2 = i;
                break;
            }
        }

        return idx1 != -1 && idx2 != -1;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(canThreePartsEqualSum(new int[] {0,2,1,-6,6,7,9,-1,2,0,1}));
        System.out.println(canThreePartsEqualSum(new int[] {29,31,27,-10,-67,22,15,-1,-16,-29,59,-18,48}));
        System.out.println(canThreePartsEqualSum(new int[] {1,-1,1,-1}));
    }

}
