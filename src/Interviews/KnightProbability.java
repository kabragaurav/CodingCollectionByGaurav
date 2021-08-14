/**
 * DE Shaw
 * On an NxN chessboard, a knight starts at the cell (x, y) and attempts to make exactly k moves.
 * The rows and columns are 0-indexed, so the top-left cell is (0, 0),
 * and the bottom-right cell is (N - 1, N - 1).
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random
 * (even if the piece would go off the chessboard it proceeds once).
 * The knight continues moving until it has made exactly k moves or has moved off the chessboard.
 * Find the probability that the knight remains on the board after it has stopped moving.
 */
package Interviews;

/**
 * @author gaurav kabra
 * @since 14 August 2021
 */

import java.util.HashMap;
import java.util.Map;

public class KnightProbability {

    private static int[][] directions = {
            {-2,-1}, {-1,-2}, {1,-2}, {2,-1},
            {2,1}, {1,2}, {-1,2}, {-2,1}
    };

    private static boolean leadsInside(int N, int x, int y) {
        return x >= 0 &&
                y >= 0 &&
                x < N &&
                y < N;
    }

    private static double knightProbabilityHelper(int N, int k, int x, int y, Map<String, Double> cache) {
        /**
         * Logic:
         * We actually get a tree-like structure when we start drawing coordinates where we will move.
         * Each level gets decreased value of k by 1.
         * E.g. at root, k=8.
         * at first level, k=7 and so on.
         * Here is an excellent video : https://tinyurl.com/knight-move
         *
         * If we get outside, then return 0. If k is 0, then return 1.
         * Else check if for (x,y,k) combination, we already had visited the cell. If so return cached value.
         * Else for each node on same level of tree, add the values divided by 8.
         */
        if(!leadsInside(N, x, y)) {
            return 0d;
        }
        if(k == 0) {
            return 1d;
        }
        String key = x + " " + y + " " + k;
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        double prob = 0d;
        for(int[] direction : directions) {
            prob += knightProbabilityHelper(N, k-1, x+direction[0], y+direction[1], cache)/8d;
        }
        cache.put(key, prob);
        return prob;
    }

    private static double knightProbability(int N, int k, int x, int y) {
        Map<String, Double> cache = new HashMap<>();
        return knightProbabilityHelper(N, k, x, y, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(knightProbability(3,2,0,0));
        System.out.println(knightProbability(8, 9, 6, 4));
    }
}
