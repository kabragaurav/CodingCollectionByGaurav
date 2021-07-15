/**
 * Salesforce
 * Given a matrix grid. From grid[i][j], we can move to grid[i+1][j], if grid[i+1][j] > grid[i][j], 
 * or can move to grid[i][j+1] if grid[i][j+1] > grid[i][j]. 
 * The task is print longest path length if we start from top left corner, i.e., (0, 0).
 */
package DP.Grids;

/**
 * @author gaurav kabra
 * @since June 26, 2021
 */

public class LongestIncreasingPath {
	
	private int helperGetLongestIncreasingPathLength(int[][] grid, int M, int N, int i, int j) {
		
		int down = 0;
		int right = 0;
		if(i < M && grid[i+1][j] > grid[i][j]) {
			down = 1 + helperGetLongestIncreasingPathLength(grid, M, N, i+1, j);
		}
		if(j < N && grid[i][j+1] > grid[i][j]) {
			right = 1 + helperGetLongestIncreasingPathLength(grid, M, N, i, j+1);
		}
		
		return Math.max(down, right);
		
	}
	
	private int getLongestIncreasingPathLength(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		
		return helperGetLongestIncreasingPathLength(grid, rows-1, columns-1, 0, 0);
	}

	

	public static void main(String[] args) {
		
		int[][] grid1 = {
	            { 1, 2, 3, 4 },
	            { 2, 2, 3, 4 },
	            { 3, 2, 3, 4 },
	            { 4, 5, 6, 7 },
	    };
		int[][] grid2 = {
				{1, 2},
				{3, 4}
		};
		int[][] grid3 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		int[][] grid4 = {
				{3, 4, 5},
				{6, 2, 6},
				{2, 2, 1}
		};
		int[][] grid5 = {
				{3, 2, 3},
				{0, 2, 2},
				{2, 0, 4}, 
				{3, 1, 0}
		};
		
		LongestIncreasingPath lip = new LongestIncreasingPath();
		
		System.out.println(lip.getLongestIncreasingPathLength(grid1));
		System.out.println(lip.getLongestIncreasingPathLength(grid2));
		System.out.println(lip.getLongestIncreasingPathLength(grid3));
		System.out.println(lip.getLongestIncreasingPathLength(grid4));
		System.out.println(lip.getLongestIncreasingPathLength(grid5));

	}

}
