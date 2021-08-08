/**
 * Google
 *  Given a staircase with N steps and the ability to climb either one or two steps at a time, 
 *  return the total number of ways to arrive at the top of the staircase.
 */
package DP.Others;

/**
 * @author gaurav kabra
 * @since August 08, 2021
 */

public class DistinctWaysToClimb {
	
	private static int getWays(int N, int start, int[] cache) {
		/**
		 * Logic:
		 * If we go beyond N, then we found no new way. So return 0.
		 * If we reach at N, we found a new way. So return 1.
		 * Else just climb by +1 and +2 and add the number of ways by doing so.
		 */
        if(start > N) {
            return 0;
        }
        if(start == N) {
            return 1;
        }
        if(cache[start] != 0) {
            return cache[start];
        }
        return cache[start] = getWays(N, start+1, cache) + getWays(N, start+2, cache);
    }

	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		int[] cache = new int[2];
		System.out.println(getWays(2, 0, cache));
		cache = new int[3];
		System.out.println(getWays(3, 0, cache));
	}

}
