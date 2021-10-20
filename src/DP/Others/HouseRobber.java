/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into
 * on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
package DP.Others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 20 Oct 2021
 **/
public class HouseRobber {

    private static Map<String, Integer> mp;

    /**
     * Logic:
     * We have only two variables in the method - curr and sumSoFar.
     * So we maintain in the map a key formed by these two. And store the value corresponding to
     * the key added.
     */
    private static int getMaxRob(int[] nums, int curr, int N, int sumSoFar) {
        if(curr >= N) {
            return sumSoFar;
        }
        if(mp.containsKey(""+curr+sumSoFar)) {
            return mp.get(""+curr+sumSoFar);
        }
        int ans =  Math.max(
                getMaxRob(nums, curr+2, N, sumSoFar+nums[curr]),
                getMaxRob(nums, curr+1, N, sumSoFar)
        );
        mp.put(""+curr+sumSoFar, ans);
        return ans;
    }

    private static int rob(int[] nums) {
        // reset as it is static and is shared by all class instances
        mp = new HashMap<>();
        return getMaxRob(nums, 0, nums.length, 0);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(rob(new int[] {
                1,2,1,1
        }));
    }
}
