/**
 * You are given weights and values of N items, put these items in a knapsack of capacity W
 * to get the maximum total value in the knapsack. Note that we have only one quantity of
 * each item.
 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values
 * and weights associated with N items respectively. Also given an integer W which represents
 * knapsack capacity, find out the maximum value subset of val[] such that sum of the weights
 * of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 */
package Company.Amazon;

/**
 * @author gkabra
 * @since 28-01-2022 Fri
 **/

public class _01Knapsack {

    private static int knapsack(int W, int curr, int end, int[] wt, int[] val, int[][] cache) {
        if(W < 0 || curr >= end) {
            return 0;
        }
        if(cache[W][curr] != 0) {
            return cache[W][curr];
        }
        int with = 0, without = 0;
        if(W >= wt[curr]) {             // remember this if block must be added
            with = val[curr] + knapsack(W-wt[curr], curr+1, end, wt, val, cache);
        }
        without = knapsack(W, curr+1, end, wt, val, cache);
        return cache[W][curr] = Math.max(with, without);
    }

    private static int knapSack(int W, int wt[], int val[], int n) {
        int[][] cache = new int[W+1][val.length+1];
        return knapsack(W, 0, n, wt, val, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(knapSack(4, new int[] {4,5,1}, new int[] {1,2,3}, 3));
    }

}
