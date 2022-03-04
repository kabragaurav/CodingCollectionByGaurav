/**
 * Given an array arr of distinct
 * integers and a nonnegative integer k, write a function findPairsWithGivenDifference
 * that returns an array of all pairs [x,y] in arr, such that x - y = k.
 * If no such pairs exist, return an empty array.
 *
 * The order of the pairs in the output array should maintain the order of the y element
 * in the original array.
 */
package Company.Pramp;

import Arrays.Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

/**
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class PairsWithSpecificDiff {

    // TC : O(NlogN)
    // SC : O(N)
    private static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        HashMap<Integer, Integer> mapNumberToIndex = new HashMap<>();

        List<int[]> ls = new ArrayList<>();
        int N = arr.length;

        for(int i=0; i<N; i++) {
            int num = arr[i];
            int pair1 = num-k;
            int pair2 = num+k;
            int[] t;
            if(mapNumberToIndex.containsKey(pair1)) {
                t = new int[] {num, pair1};
                ls.add(t);
            }
            if(mapNumberToIndex.containsKey(pair2)) {
                t = new int[] {pair2, num};
                ls.add(t);
            }
            mapNumberToIndex.put(num, i);
        }

        int sz = ls.size();
        int[][] ans = new int[sz][2];
        int m = 0;
        for(int[] temp : ls) {
            ans[m][0] = temp[0];
            ans[m][1] = temp[1];
            m++;
        }

        Arrays.sort(ans, (int[] num1, int[] num2) -> mapNumberToIndex.get(num1[1]) - mapNumberToIndex.get(num2[1]));
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        ArrayUtils.printArray(findPairsWithGivenDifference(new int[] {0, -1, -2, 2, 1}, 1));
    }

}
