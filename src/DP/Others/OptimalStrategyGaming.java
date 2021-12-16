/**
 * Alice and Bob play a game with piles of stones. There are an even
 * number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * The objective of the game is to end with the most stones. The total number of stones across
 * all the piles is odd, so there are no ties.
 * Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire
 * pile of stones either from the beginning or from the end of the row. This continues until
 * there are no more piles left, at which point the person with the most stones wins.
 * Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.
 */
package DP.Others;

import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * @author gaurav kabra
 * @since 16 Dec 2021
 **/

public class OptimalStrategyGaming {

    private static HashMap<String, Boolean> mp;

    private static boolean isPossibleToWin(int[] piles, int start, int end, int total, int sum) {
        if(total > (sum-total)) {
            return true;
        }
        if(start > end) {
            return total > (sum-total);
        }
        // Remember using dynamic programming (DP)
        String key = start + " " + end;
        if(mp.containsKey(key)) {
            return mp.get(key);
        }

        // we can choose from start. Then friend can choose from start+1 to end
        // or can choose from end. Then friend can choose from start to end-1
        boolean isWinnable =  isPossibleToWin(piles, start+2, end, total+piles[start], sum)
                || isPossibleToWin(piles, start+1, end-1, total+piles[start], sum)
                || isPossibleToWin(piles, start+1, end-1, total+piles[end], sum)
                || isPossibleToWin(piles, start, end-2, total+piles[end], sum);

        mp.put(key, isWinnable);
        return isWinnable;
    }


    private static boolean stoneGame(int[] piles) {
        mp = new HashMap<>();
        // find sum of numbers in array
        int sum = IntStream.of(piles).sum();
        return isPossibleToWin(piles, 0, piles.length-1, 0, sum);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(stoneGame(new int[] {5,3,4,5}));
    }
}
