/**
 * Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into
 * two subsets such that the sum of elements in both subsets is equal.
 */
package DP.Others;

import java.util.HashMap;

/**
 * @author gaurav kabra
 * @since 8 Dec 2021
 **/

public class PartitionEqualSums {

    private static boolean isAchievable(int[] nums, int curr, int sum, HashMap<String, Boolean> cache) {
        if(sum == 0) {
            return true;
        }
        if(sum < 0 || curr >= nums.length) {
            return false;
        }
        // Remember your past!
        String key = Integer.toString(curr) + "_" + Integer.toString(sum);
        if(cache.containsKey(key)) {        // has seen this somewhere earlier...
            return cache.get(key);          // then just return the result
        }
        boolean resp = isAchievable(nums, curr+1, sum-nums[curr], cache)        // choose
                || isAchievable(nums, curr+1, sum, cache);                          // not choose
        cache.put(key, resp);
        return resp;
    }

    /**
     * We can partition array in two parts having equal sum iff its total sum is even, i.e., (sum & 1) == 0
     * Then we choose one element and see if we can achieve this.
     * If not, we do not choose the element and see if we can achieve this.
     * If yes, we return true.
     * Else false.
     */
    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        HashMap<String, Boolean> cache = new HashMap<>();
        return (sum & 1) == 0 && isAchievable(nums, 0, sum/2, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(canPartition(new int[]{2,2,3,5}));
        System.out.println(canPartition(new int[]{1,3,2}));
    }
}
