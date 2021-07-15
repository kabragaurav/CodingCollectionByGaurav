/**
 * Amazon
 * Given a 2D matrix that represents a gold mine, where each cell’s value represents an amount of gold, 
 * return the maximum amount of gold you can collect given the following rules:
 * You may start and stop collecting gold from any position
 * You can never visit a cell that contains 0 gold
 * You cannot visit the same cell more than once
 * From the current cell, you may walk one cell to the left, right, up, or down
 */

package DepthFirstSearch;

/**
 * @author gaurav kabra
 * @since July 3, 2021
 */

public class GoldRush {
	
		private int[][] dirs = {
		        {0, 1},
		        {1, 0},
		        {0, -1},
		        {-1, 0}
	    	};
	    
	    private boolean isSafe(int[][] grid, int x, int y) {
	        return x >=0 
	            && y >=0
	            && x < grid.length
	            && y < grid[0].length
	            && grid[x][y] != 0;
	    }
	    
	    private int getMaxValue(int[][] grid, int x, int y) {
	    	/**
	    	 * Logic:
	    	 * From the present cell, we move to 4 directions: right, botton, left and up
	    	 * And see in which direction, we get what amounts of gold
	    	 * We take max of those amounts and store in max
	    	 * Note that we don't keep coming to same cell, so we set it temporarily to 0
	    	 * 
	    	 * Time Complexity: O(4 * 3^(max(N-1), max(N-1)) ~ O(3^N), where N is one dimension of grid. Because at starting from any cell, we can move in 4 directions. For remaining, we have 3 directions only.
	    	 * Space Complexity: O(M * N) for implicit stack where grid is of dimensions MxN, worst case when no 0 is there
	    	 */
	        if(!isSafe(grid, x, y)) {
	            return 0;
	        }
	        int max = Integer.MIN_VALUE;
	        int t = grid[x][y];
	        grid[x][y] = 0;
	        
	        for(int[] dir : dirs) {
	            max = Math.max(max, t + getMaxValue(grid, x+dir[0], y+dir[1]));
	        }
	        
	        grid[x][y] = t;		// backtrack
	        return max;
	    }
	    
	    private int getMaximumGold(int[][] grid) {
	    	/**
	    	 * Logic:
	    	 * We start from each cell and try to collect gold
	    	 * We return max gold amount that we can get by doing so
	    	 */
	        int max = Integer.MIN_VALUE;
	        
	        for(int i=0; i<grid.length; i++) {
	            for(int j=0; j<grid[0].length; j++) {
	                max = Math.max(max, getMaxValue(grid, i, j));
	            }
	        }
	        return max;
	    }
	    
	    // driver - main method
		public static void main(String[] args) {
			// TESTCASE
			System.out.println(new GoldRush().getMaximumGold(new int[][] {
				{0,6,0},{5,8,7},{0,9,0}
			}));
			// worst case - No 0
			System.out.println(new GoldRush().getMaximumGold(new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}));
			
		}

}
