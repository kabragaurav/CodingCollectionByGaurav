/**
 * Alice and Bob play a game with piles of stones.
 * There are an even number of piles arranged in a row, and each pile has a positive
 * integer number of stones piles[i].
 * The objective of the game is to end with the most stones. The total number of stones
 * across all the piles is odd, so there are no ties.
 * Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire
 * pile of stones either from the beginning or from the end of the row. This continues until
 * there are no more piles left, at which point the person with the most stones wins.
 * Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob
 * wins.
 */
package GameTheory;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 17-02-2022 Thu
 **/

public class StoneGame {

    private static boolean helper(int[] piles, int curr, int sum, int left, int right, int[][] cache) {
        if(left > right) {
            return curr > sum/2;
        }
        if(cache[left][right] != -1) {
            return cache[left][right] == 1 ? true : false;
        }
        boolean ans = helper(piles, curr+piles[left], sum, left+2, right, cache)
                || helper(piles, curr+piles[right], sum, left, right-2, cache);
        cache[left][right] = ans == true ? 1 : 0;
        return ans;
    }

    private static boolean stoneGame(int[] piles) {
        int sum = 0;
        for(int pile : piles) {
            sum += pile;
        }
        int N = piles.length;
        int i = 0, j = N-1;
        int[][] cache = new int[N][N];
        Arrays.stream(cache).forEach(x -> Arrays.fill(x, -1));
        return helper(piles, 0, sum, i, j, cache);
    }

    public static void main(String[] args) {
        // FUN FACT : Answer will always be true, Alice will always win!
        // so return true; always passes!!
        System.out.println(stoneGame(new int[] {5,3,4,5}));
    }

}
