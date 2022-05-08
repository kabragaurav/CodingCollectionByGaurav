/*
You have n dice and each die has k faces numbered from 1 to k.
Given three integers n, k, and target, return the number of possible ways (out of the kn total ways)
to roll the dice so the sum of the face-up numbers equals target. Since the answer may be too large,
return it modulo 10^9 + 7.
 */
package DP.Others;

import java.util.HashMap;

public class DiceRollWaysForTarget {

    private static final int MOD = 1000_000_007;

    public static int numRollsToTarget(int n, int k, int target) {
        HashMap<String, Integer> cache = new HashMap<>();
        return helper(0, 0, n, k, target, cache) % MOD;
    }

    private static int helper(int currDice, int sum, int n, int k, int target, HashMap<String, Integer> cache) {

        String key = currDice + "_" + sum;
        int ways = 0;

        if (currDice == n) {
            ways = sum == target ? 1 : 0;
            cache.put(key, ways);
            return ways;
        }

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        for (int i=1; i<=k; i++) {
            int way = helper(currDice+1, sum+i, n, k, target, cache) % MOD;
            ways += way;
            ways %= MOD;
        }

        ways %= MOD;
        cache.put(key, ways);
        return ways;
    }
    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(numRollsToTarget(1,6,3));
        System.out.println(numRollsToTarget(2,6,7));
        System.out.println(numRollsToTarget(30,30,500));
    }

}
