/**
 * Google
 * A ball is dropped into a special Galton board where at each level in the board the ball can only
 * move right or down. Given that the Galton board has M rows and N columns, 
 * return the total number of unique ways the ball can arrive at the bottom right cell of the Galton board.
 * 
 * Galton board is a device to illustrate the binomial distribution, usually with little balls 
 * falling through grid of pegs where the balls bounce back and forth from one peg to another, 
 * to come to rest in little bins at the bottom.
 * 
 * Visualization: https://tinyurl.com/galton-grid
 */
package DP.Others;

/**
 * @author gaurav kabra
 * @since July 18, 2021
 */

public class GaltonBoard {
	
	private static int getNumberOfUniquePaths(int x, int y, int m, int n, int[][] cache) {
		/**
		 * Logic:
		 * If we go outside grid, then there is 0 ways.
		 * If we reach bottom right corner, we found 1 way to reach. Hence return 1.
		 * Else add number of ways to reach bottom right corner, one going down, once going right.
		 */
        if(x > m || y > n)
            return 0;
        if(x == m && y == n)
            return 1;
        if(cache[x][y] != 0)
            return cache[x][y];
        return cache[x][y] = getNumberOfUniquePaths(x+1, y, m, n, cache)
               + getNumberOfUniquePaths(x, y+1, m, n, cache);
    }
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASE
		System.out.println(getNumberOfUniquePaths(0, 0, 14, 14, new int[15][15]));
	}

}
