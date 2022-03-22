/*
    Given an integer array nums, find a contiguous non-empty subarray within the array that has the
    largest product, and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.
 */
package Company.Zoho;

import java.util.HashMap;

/**
 * @author gauravkabra
 * @since 22/Mar/2022
 **/

public class MaximumProductSubarray {

    // ===========

    private static boolean isOne = false;
    private static int max = Integer.MIN_VALUE;

    private static int helper(int[] nums, int curr, int N, int p, HashMap<String, Integer> cache) {
        if (curr == N) {
            return p;
        }

        if (nums[curr] == 1 || p*nums[curr] == 1) {
            isOne = true;
        }
        String key = p + "_" + curr;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        max = Math.max(max, nums[curr]);

        int with = helper(nums, curr+1, N, p*nums[curr], cache);
        int without = helper(nums, curr+1, N, 1, cache);
        int ans = Math.max(p, Math.max(with, without));
        cache.put(key, ans);
        return ans;
    }

    private static int maxProductDp(int[] nums) {
        int N = nums.length;
        isOne = false;
        max = Integer.MIN_VALUE;
        HashMap<String, Integer> cache = new HashMap<>();
        int ans = helper(nums, 0, N, 1, cache);
        if (ans == 1) {
            return isOne ? 1 : max;
        }
        return ans;
    }

    // ===========

    // TC : O(N)
    // SC : O(1)
    private static int maxProductOptimal(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);

            ans = Math.max(ans, max);
        }

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(maxProductOptimal(new int[] {-2}));
        System.out.println(maxProductOptimal(new int[] {-3,-1,-1}));
        System.out.println(maxProductOptimal(new int[] {-1,-1}));

        System.out.println(maxProductDp(new int[] {-2}));
        System.out.println(maxProductDp(new int[] {-3,-1,-1}));
        System.out.println(maxProductDp(new int[] {-1,-1}));
    }

}
