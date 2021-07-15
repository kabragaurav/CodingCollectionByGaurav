/**
 * Count all the possible paths from top left to bottom right of a mXn matrix with the 
 * constraints that from each cell you can either move only to right or down.
 */
package DP.Grids;

/**
 * @author gaurav kabra
 * @since June 26, 2021
 */

public class PathsFromTopLeftToBottomRight {
	
	private int getNumberOfUniquePaths(int x, int y, int m, int n, int[][] cache) {
		/**
		 * Logic:
		 * We try to go right and down. If any time, we exceed bounds of array, we return 0 indicating we cannot reach bottom right in this way.
		 * If we reach, we return 1 contributing one more path following which we can reach bottom right.
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
    
    private int uniquePaths(int m, int n) {
        return getNumberOfUniquePaths(0, 0, m-1, n-1, new int[m+1][n+1]);
    }
    
    // driver - main method
	public static void main(String[] args) {
		// TESTCASE
		System.out.println(new PathsFromTopLeftToBottomRight().uniquePaths(3, 3));
	}

}
