/**
 * Given a set of N items, each with a weight and a value, represented by the array w[]
 * and val[] respectively. Also, a knapsack with weight limit W.
 * The task is to fill the knapsack in such a way that we can get the maximum profit.
 * Return the maximum profit.
 * Each item can be taken any number of times (Unbounded condition)
 */
package Company.Amazon;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 30-01-2022 Sun
 **/

public class _01KnapsackUnbounded {

    private static int helper(int curr, int W, int N, int[] val, int[] wt, int[][] cache) {
        if(curr >= N || W <= 0) {
            return 0;
        }
        if(cache[curr][W] != -1) {
            return cache[curr][W];
        }
        int with = 0, without = 0;
        if(wt[curr] <= W) {
            with = val[curr] + helper(curr, W-wt[curr], N, val, wt, cache);
        }
        without = helper(curr+1, W, N, val, wt, cache);
        return cache[curr][W] = Math.max(with, without);
    }


    // TC : O(N*W)
    // SC : O(N*W)
    private static int knapSack(int N, int W, int[] wt, int[] val) {
        int[][] cache = new int[N+1][W+1];
        Arrays.stream(cache).forEach(x -> Arrays.fill(x, -1));
        return helper(0, W, N, val, wt, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(knapSack(3, 4, new int[] {4,5,1}, new int[] {1,2,3}));
    }

}
