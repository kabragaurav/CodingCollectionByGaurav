/*
Version #1:
Given an integer array nums and an integer k,
return the number of non-empty subarrays that have a sum divisible by k.

Version #2:
Given an integer array nums and an integer k, return true if nums has a continuous subarray whose elements
sum up to a multiple of k, or false otherwise.

 */
package Map;

import java.util.HashMap;

/**
 * @author gaurav kabra
 * @since 08/May/2022
 **/

public class KDivisibilitySubarrays {

    // TC : O(N)
    // SC : O(k)
    /*
        Idea:
        About the problems - sum of contiguous subarray , prefix sum is a common technique.
        Another thing is if sum[0, i] % K == sum[0, j] % K, sum[i + 1, j] is divisible by K.
        So for current index j, we need to find out how many index i (i < j) exist that has the same mod of K.
        Now it easy to come up with HashMap <mod, frequency>
     */
    private static int subarraysDivByK(int[] nums, int k) {
        // can also use int[] of size k for map
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum = (prefixSum + num) % k;
            if (prefixSum < 0) {
                prefixSum += k;
            }
            count += mp.getOrDefault(prefixSum, 0);
            mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(subarraysDivByK(new int[] {4,5,0,-2,-3,1}, 5));
    }

}
