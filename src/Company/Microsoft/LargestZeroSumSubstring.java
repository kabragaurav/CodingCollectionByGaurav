/*
Find the largest continuous sequence in a array which sums to zero.
 */
package Company.Microsoft;

import Arrays.Utils.ArrayUtils;

import java.util.HashMap;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class LargestZeroSumSubstring {

    private static int[] lszero(int[] A) {
        int N = A.length;
        int maxLen = 0;
        int prefixSum = 0;
        int start = -1;
        int end = -1;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);                                          // make sure to put it. [1,2,-3]

        for (int i=0; i<N; i++) {
            prefixSum += A[i];
            if (mp.containsKey(prefixSum)) {
                if (i - mp.get(prefixSum) > maxLen) {
                    start = mp.get(prefixSum)+1;                // Note these assignments carefully. Most chances of error here
                    end = i;
                    maxLen = end-start+1;
                }
            } else {
                mp.put(prefixSum, i);
            }
        }

        if (start >= 0 && end >= 0) {                   // This condition is imp (What is no 0 sum found, start and end will be -1)
            int[] ans = new int[end-start+1];
            for (int i=0; i<ans.length; i++) {          // i loops from 0, so that ans[i] is within array length bounds
                ans[i] = A[start+i];
            }
            return ans;
        }

        return new int[] {};
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        ArrayUtils.printArray(lszero(new int[] {1,2,-3,3}));
        ArrayUtils.printArray(lszero(new int[] {1,2,-3}));
        ArrayUtils.printArray(lszero(new int[] {2,-2,4,-4}));
        ArrayUtils.printArray(lszero(new int[] {0, -10, -12, -8, 21, -11, -28, -11, 0, -8, 17, -1, -4, -7, -5, 22, -26, -24, -7, 13, 18, -21, 10}));
    }

}
