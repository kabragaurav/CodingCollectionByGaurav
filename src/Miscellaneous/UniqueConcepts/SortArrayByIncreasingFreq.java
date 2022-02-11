/**
 * Given an array of integers nums, sort the array in increasing order based on the
 * frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 * Return the sorted array.
 */
package Miscellaneous.UniqueConcepts;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * @author gkabra
 * @since 11-02-2022 Fri
 **/

public class SortArrayByIncreasingFreq {

    // TC : O(NlogN)
    // SC : O(N)
    private static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int N = nums.length;

        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        int[][] arr = new int[N][2];   // 2 columns : value, its freq

        for(int i=0; i<N; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = mp.get(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) {
                return b[0]-a[0];    // decreasing order of value
            }
            return a[1]-b[1];       // natural/increasing order of freq
        });

        int[] ans = new int[N];
        for(int i=0; i<N; i++) {
            ans[i] = arr[i][0];
        }

        return ans;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        int[] ans = frequencySort(new int[] {2,3,1,3,2});
        for(int num : ans) {
            System.out.println(num);
        }
    }

}
