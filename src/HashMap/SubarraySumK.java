/**
 * Given an array of integers nums and an integer k,
 * return the total number of continuous subarrays whose sum equals to k.
 */
package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 10 Nov 2021
 **/

public class SubarraySumK {

    /**
     * Logic:
     * If we have prefix sum and choose two indices of an array,
     * and let right one is S1 and left one is S2.
     * If S1-S2 = k, then we have a subarray between these two indices that sum to k.
     *
     * To know only contiguous subarray, we use for loop and keep forwarding i.
     *
     * Since negative numbers can be there, we don't want to use sliding window here.
     *
     * TC : O(N)
     * SC : O(N) due to map.
     */
    private static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(mp.containsKey(sum-k)) {
                count += mp.get(sum-k);
            }
            // this should come at last
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(subarraySum(new int[] {1,-1,0}, 0));     // [1,-1]  [1,-1,0]  [0]
        System.out.println(subarraySum(new int[] {-1,-1,1}, 0));
        System.out.println(subarraySum(new int[] {1}, 0));
    }
}
