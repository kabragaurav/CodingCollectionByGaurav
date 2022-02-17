/**
 * In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10.
 * The player who first causes the running total to reach or exceed 100 wins.
 * What if we change the game so that players cannot re-use integers?
 * For example, two players might take turns drawing from a common pool of numbers from 1 to 15
 * without replacement until they reach a total >= 100.
 * Given two integers maxChoosableInteger and desiredTotal, return true if the first player
 * to move can force a win, otherwise, return false. Assume both players play optimally.
 */
package GameTheory;

import java.util.HashMap;

/**
 * @author gkabra
 * @since 17-02-2022 Thu
 **/

public class Game100 {

    private static boolean game100(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= maxChoosableInteger) {
            return true;
        }
        int maxSum = maxChoosableInteger * (maxChoosableInteger+1)/2;
        if(maxSum < desiredTotal) {
            return false;
        }
        HashMap<String, Boolean> cache = new HashMap<>();
        return helper(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger+1], cache);
    }


    private static boolean helper(int maxChoosableInteger, int desiredTotal, boolean[] chosen, HashMap<String, Boolean> cache) {
        if(desiredTotal <= 0) {
            return false;
        }
        String key = getKey(chosen);
        if(cache.get(key) != null) {
            return cache.get(key);
        }
        for(int i=1; i<=maxChoosableInteger; i++) {
            if(chosen[i]) {
                continue;
            }
            chosen[i] = true;
            if(!helper(maxChoosableInteger, desiredTotal-i, chosen, cache)) {
                chosen[i] = false;
                cache.put(getKey(chosen), true);
                return true;
            }
            chosen[i] = false;
        }
        cache.put(getKey(chosen), false);
        return false;
    }

    private static String getKey(boolean[] chosen) {
        int key = 0;
        for(boolean e: chosen) {
            key <<= 1;
            key += e ? 1 : 0;
        }

        return Integer.toString(key);
    }

    public static void main(String[] args) {
        System.out.println(game100(10, 11));
    }

}
