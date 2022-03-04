/**
 * Given an integer n,
 * return any array containing n unique integers such that they add up to 0.
 */
package Arrays;

import Arrays.Utils.ArrayUtils;

/**
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class UniqueIntegersSumToZero {

    // TC : O(N) for populating array
    // SC : O(1)
    private static int[] sumZero(int n) {
        int[] ans = new int[n];
        boolean isOdd = false;
        if(n%2 == 1) {
            isOdd = true;
        }
        int count = 1;
        for(int i=0; i<n-1; i+=2) {
            ans[i] = count;
            ans[i+1] = -count;
            count++;
        }
        if(isOdd) {
            ans[ans.length-1] = 0;
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        ArrayUtils.printArray(sumZero(5));
        ArrayUtils.printArray(sumZero(6));
    }

}
