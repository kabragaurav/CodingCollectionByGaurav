package Company.Amazon;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 26-01-2022 Wed
 **/

public class CoinChangeInfCoins {

    private static int feasible(int amount, int[] coins, int curr, int[][] cache) {
        if(amount == 0) {
            return 1;
        }
        if(amount < 0 || coins.length <= curr) {
            return 0;
        }
        if(cache[amount][curr] != -1) {
            return cache[amount][curr];
        }
        int without = feasible(amount, coins, curr+1, cache);
        int with = feasible(amount-coins[curr], coins, curr, cache);
        return cache[amount][curr] = with + without;
    }

    private static int change(int amount, int[] coins) {
        // amount+1 because we also want to store the solution for the 0 amount.
        int[][] cache = new int[amount+1][coins.length+1];
        Arrays.stream(cache).forEach(a -> Arrays.fill(a, -1));
        return feasible(amount, coins, 0, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(change(5, new int[] {1,2,5}));
        System.out.println(change(3, new int[] {2}));
    }

}
