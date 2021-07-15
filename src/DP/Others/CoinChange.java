/**
 * Given an array of coins (value > 0) representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * Assume that you have an infinite number of each kind of coin.
 */
package DP.Others;

/**
 * @author gaurav kabra
 * @since June 26, 2021
 */

public class CoinChange {
	
	private static final int SOME_BIG_INT = 100000000;
    
    private int coinHelper(int[] coins, int amount, int current, int[][] cache) {
    	/**
    	 * If amount < 0 or index of current position exceeds bounds of array, we return very large value indicating that we will return -1 saying we cannot make that amount.
    	 * If amount becomes 0, that means there is 0 number of coins are required to make that amount.
    	 * Else once we choose coin at current value and see number of coins to make amount.
    	 * And once we donot choose the current coin and see number of coins to make amount.
    	 * We return min of these two.
    	 */
        if(amount < 0 || current >= coins.length)
            return SOME_BIG_INT;
        if(amount == 0)
            return 0;
        if(cache[current][amount] != 0)
           return cache[current][amount]; 
        return cache[current][amount] = Math.min(
                            coinHelper(coins, amount, current+1, cache),
                            1 + coinHelper(coins, amount-coins[current], current, cache)
                        );
    }
    
    private int coinChange(int[] coins, int amount) {
        int ans = coinHelper(coins, amount, 0, new int[coins.length+1][amount+1]);
        return ans == SOME_BIG_INT ? -1 : ans;
    }

    // driver - main method
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		
		// TESTCASES
		System.out.println(cc.coinChange(new int[] {2}, 3));
		System.out.println(cc.coinChange(new int[] {1,2,5}, 11));
	}

}
