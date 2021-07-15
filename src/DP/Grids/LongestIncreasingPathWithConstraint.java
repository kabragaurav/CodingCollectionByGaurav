/**
 * Salesforce
 * Given a matrix grid.  Your task is to find the length of the longest increasing path in matrix.
 * From each cell, you can either move in four directions: left, right, up, or down.
 */
package DP.Grids;

/**
 * @author gaurav kabra
 * @since June 26, 2021
 */

public class LongestIncreasingPathWithConstraint {
	
	private int helperGetLongestIncreasingPathLength(int[][] grid, int M, int N, int i, int j, int[][] cache) {
		if(cache[i][j] != 0)
			return cache[i][j];
		int down = 0;
		int right = 0;
		int up = 0;
		int left = 0;
		if(i < M && grid[i+1][j] > grid[i][j]) {
			down = 1 + helperGetLongestIncreasingPathLength(grid, M, N, i+1, j, cache);
		}
		if(j < N && grid[i][j+1] > grid[i][j]) {
			right = 1 + helperGetLongestIncreasingPathLength(grid, M, N, i, j+1, cache);
		}
		if(i > 0 && grid[i-1][j] > grid[i][j]) {
			up = 1 + helperGetLongestIncreasingPathLength(grid, M, N, i-1, j, cache);
		}
		if(j > 0 && grid[i][j-1] > grid[i][j]) {
			left = 1 + helperGetLongestIncreasingPathLength(grid, M, N, i, j-1, cache);
		}
		return cache[i][j] = Math.max(Math.max(down, right), Math.max(up, left));
		
	}
	
	private int getLongestIncreasingPathLength(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		
		int max = Integer.MIN_VALUE;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                max = Math.max(max,
                				helperGetLongestIncreasingPathLength(grid, rows-1, columns-1, i, j, new int[rows][columns])
                				);
            }
        }
        return max;
	}

	

	public static void main(String[] args) {
		
		int[][] grid1 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		int[][] grid2 = {
				{3, 4, 5},
				{6, 2, 6},
				{2, 2, 1}
		};
		int[][] grid3 = {
				{3, 2, 3},
				{0, 2, 2},
				{2, 0, 4}, 
				{3, 1, 0}
		};
		
		int[][] grid4 = {
				{0,1,2,3,4,5,6,7,8,9},
				{19,18,17,16,15,14,13,12,11,10},
				{20,21,22,23,24,25,26,27,28,29},
				{39,38,37,36,35,34,33,32,31,30},
				{40,41,42,43,44,45,46,47,48,49},
				{59,58,57,56,55,54,53,52,51,50},
				{60,61,62,63,64,65,66,67,68,69},
				{79,78,77,76,75,74,73,72,71,70},
				{80,81,82,83,84,85,86,87,88,89},
				{99,98,97,96,95,94,93,92,91,90},
				{100,101,102,103,104,105,106,107,108,109},
				{119,118,117,116,115,114,113,112,111,110},
				{120,121,122,123,124,125,126,127,128,129},
				{139,138,137,136,135,134,133,132,131,130},
				{0,0,0,0,0,0,0,0,0,0}
		};
		
		
		LongestIncreasingPathWithConstraint lipwc = new LongestIncreasingPathWithConstraint();
		
		System.out.println(lipwc.getLongestIncreasingPathLength(grid1));
		System.out.println(lipwc.getLongestIncreasingPathLength(grid2));
		System.out.println(lipwc.getLongestIncreasingPathLength(grid3));
		System.out.println(lipwc.getLongestIncreasingPathLength(grid4));

	}

}
