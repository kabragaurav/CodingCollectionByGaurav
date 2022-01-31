/**
 * You are given k identical eggs
 * and you have access to a building with n floors labeled from 1 to n.
 *
 * You know that there exists a floor f where 0 <= f <= n such that any egg dropped
 * at a floor higher than f will break, and any egg dropped at or below floor f will not break.
 *
 * Each move, you may take an unbroken egg and drop it from any floor x
 * (where 1 <= x <= n). If the egg breaks, you can no longer use it. However,
 * if the egg does not break, you may reuse it in future moves.
 *
 * Return the minimum number of moves that you need to determine with certainty
 * what the value of f is.
 */
package Company.Amazon;

import java.util.Arrays;
/**
 * @author gkabra
 * @since 31-01-2022 Mon
 **/

public class EggDrop {

    private static int helper(int f, int e, int[][] cache) {
        if(f == 0 || f == 1) {
            return f;
        }
        if(e == 1) {            // linearly test from floor=1 to floor=f
            return f;
        }
        if(cache[f][e] != 0) {
            return cache[f][e];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=f; i++) {           // 1 to  f
            int temp = 1 + Math.max(helper(i-1, e-1, cache),            // max for worst case
                    helper(f-i, e, cache));
            ans = Math.min(ans, temp);                                      // min of worst case
        }
        return cache[f][e] = ans;
    }


    /**
     * Logic:
     *
     * Excellent explanation here: https://tinyurl.com/egg-drop
     *
     * TC : exponential
     * SC : O(e*f)
     */
    private static int eggDrop(int e, int f) {
        int[][] cache = new int[f+1][e+1];
        return helper(f, e, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(eggDrop(3, 14));
    }

}
