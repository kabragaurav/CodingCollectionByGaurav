/**
 * Google
 * You are given a bag of tokens, an initial energy of E, 
 * and want to maximize your number of points, called score (initially 0). 
 * To gain a single score you can exchange tokens[i] amount of energy 
 * (i.e. if I have 100 energy and a token that has a value 50 I can exchange 50 energy to gain a token).
 *  If you do not have enough energy you can give away a token in exchange for an increase in energy 
 *  by tokens[i] amount (i.e. you give away a token and your energy is increased by the value of 
 *  that token: energy += tokens[i]). Return the maximum number of tokens you can gain.
 *  Note: Each coin may only be used once and you can pickup tokens in any order. Not all tokens need to be used.
 */
package DP.Others;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since July 10, 2021
 */

public class MaximumScore {
	private int getMaxScore(int score, int[] tokens, int start, int end, int energy, int[][] cache) {
		/**
		 * Logic:
		 * We always buy tokens where start points and sell tokens where end points
		 * We take maximum tokens as answer that can be achieved in either ways
		 */
        if(start >= tokens.length || end < 0) 
            return score;
        if(cache[start][end] != 0)
            return cache[start][end];
        int x = -1;
        int y = -1;
        if(energy >= tokens[start]) {
            x = getMaxScore(score+1, tokens, start+1, end, energy-tokens[start], cache);
        }
        if(score >= 1) {
            y = getMaxScore(score-1, tokens, start, end-1, energy+tokens[end], cache);
        }
        
        return cache[start][end] = Math.max(Math.max(x,y), score);
    }
    
    private int bagOfTokensScore(int[] tokens, int energy) {
    	/**
    	 * Logic:
    	 * Always trade less power for a point
    	 * Always trade a point for higher power
    	 * So we sort the tokens and keep two pointers pointing to edges of tokens array
    	 * 
    	 * Space Complexity: O(N*N) for cache array
    	 */
        Arrays.sort(tokens);
        int score = 0;
        int[][] cache = new int[tokens.length][tokens.length];
        int ans = getMaxScore(score, tokens, 0, tokens.length-1, energy, cache);
        return ans;
    }
    
    // driver - main method
	public static void main(String[] args) {
		MaximumScore ms = new MaximumScore();
		// TESTCASE
		System.out.println(ms.bagOfTokensScore(new int[] {602,3001,7452,524,6211,255,4715,8885,101,5268,664,8671,6862,7419,6690,64,411,6208,9996,8731}, 6996));
		System.out.println(ms.bagOfTokensScore(new int[] {81,91,31}, 73));
		System.out.println(ms.bagOfTokensScore(new int[] {100}, 50));
	}

}
