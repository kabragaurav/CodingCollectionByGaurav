/**
 * Amazon
 * Given an integer array, two players take turns picking a number from the ends of the array.
 * First, player one picks a number (either the left end or right end of the array) followed by player
 * two. Each time a player picks a particular numbers, it is no longer available to the other player.
 * This picking continues until all numbers in the array have been chosen. 
 * Once all numbers have been picked, the player with strictly larger score wins. 
 * Return whether or not player one will win. Player one starts first always.
 * You may assume that each player is playing to win 
 * (i.e. both players will always choose the maximum of the two numbers each turn) 
 * and that there will always be a winner (no tie).
 */
package DP.Others;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since July 15, 2021
 */

public class WhoWins {
	
	private int doesFirstPlayerWin(int[] numbers, int start, int end, int[][] cache) {
		/**
		 * Logic:
		 * Since both players are playing to win, when one player chooses a number, other player chooses the next number such that first one gets min from remaining array.
		 * We want to maximize in this case.
		 * Players can pick numbers at start or at end.
		 */
		if(start > end) {
			return 0;
		}
		if(start == end) {
			return cache[start][end] = numbers[start];
		}
		if(cache[start][end] != 0) {
			return cache[start][end];
		}
		return cache[start][end] = Math.max(
				numbers[start] + Math.min(doesFirstPlayerWin(numbers, start+2, end, cache), doesFirstPlayerWin(numbers, start+1, end-1, cache)),
				numbers[end] + Math.min(doesFirstPlayerWin(numbers, start, end-2, cache), doesFirstPlayerWin(numbers, start+1, end-1, cache))
				);
	}
	
	// driver - main method
	public static void main(String[] args) {
		
		/**
		 * One possible optimization:
		 * if (numbers.length % 2 == 0) {
            	return true;
        	}
		 */
		
		// TESTCASES
		int[] numbers = {1,5,233,7};
		int[][] cache = new int[numbers.length][numbers.length];
		int total = Arrays.stream(numbers).sum();
		WhoWins ww = new WhoWins();
		int playerOneMaxScore = ww.doesFirstPlayerWin(numbers, 0, numbers.length-1, cache);
		System.out.println((total-playerOneMaxScore) < playerOneMaxScore);
		
		numbers = new int[] {1,3,1};
		cache = new int[numbers.length][numbers.length];
		playerOneMaxScore = ww.doesFirstPlayerWin(numbers, 0, numbers.length-1, cache);
		System.out.println((total-playerOneMaxScore) < playerOneMaxScore);
	}

}
