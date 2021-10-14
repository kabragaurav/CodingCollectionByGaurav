/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 4 Oct 2021
 *
 * Another beautiful solution here: https://tinyurl.com/single-stock-profit
 **/

public class SingleStockPurchase {
    /**
     * Logic:
     * We will traverse array three times:
     *      left to right for finding minimum element till now at each index
     *      right to left to find maximum element till now at each index
     *      left to right to find difference in values found at each index above and return max of it as answer
     *
     * TC: O(N) due to three time traversal of the array
     * SC: O(N) due to two arrays
     */
    private static int maxProfit(int[] prices) {
        int N = prices.length;
        int[] minTillNow = new int[N];
        int[] maxTillNow = new int[N];

        minTillNow[0] = prices[0];
        for(int i=1; i<N; i++) {
            minTillNow[i] = Math.min(minTillNow[i-1], prices[i]);
        }

        maxTillNow[N-1] = prices[N-1];
        for(int i=N-2; i>=0; i--) {
            maxTillNow[i] = Math.max(maxTillNow[i+1], prices[i]);
        }

        int max = -1;
        for(int i=0; i<N; i++) {
            max = Math.max(max, maxTillNow[i]-minTillNow[i]);
        }

        return max;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
    }
}
