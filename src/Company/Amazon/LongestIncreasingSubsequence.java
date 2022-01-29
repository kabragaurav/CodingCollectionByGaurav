package Company.Amazon;

/**
 * @author gkabra
 * @since 29-01-2022 Sat
 **/

public class LongestIncreasingSubsequence {

    private static int helper(int[] nums, int curr, int N, int prevIdx, int[][] cache) {
        if(curr >= N) {
            return 0;
        }
        if(cache[curr][prevIdx+1] != 0) {
            return cache[curr][prevIdx+1];
        }
        int with = 0, without = 0;
        if(prevIdx == -1 || nums[curr] > nums[prevIdx]) {                   // if condition is useful to add in general
            with = 1 + helper(nums, curr+1, N, curr, cache);            // in general take out value to be added. E.g. 1 here
        }
        without = helper(nums, curr+1, N, prevIdx, cache);
        return cache[curr][prevIdx+1] = Math.max(with, without);
    }

    private static int lengthOfLIS(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        int[][] cache = new int[nums.length+1][nums.length+1];
        return helper(nums, 0, nums.length, -1, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

}
