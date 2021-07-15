/**
 * Salesforce
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water).
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally 
 * or vertically. Return the number of islands.
 */
package Miscellaneous.UniqueConcepts;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author gaurav kabra
 * @since June 25, 2021
 */

public class NumberOfIslands {
	

	// direction : down, up, right, left
	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	
	private boolean isSafe(int x, int y, int[][] grid) {
		return  (x >= 0 && x < grid.length
				&& y>=0 && y < grid[0].length
				&& grid[x][y] == 1);
	}
	
	private int getNumberOfIslands(int[][] grid) {
		/**
		 * Logic:
		 * The solution is almost same as RottenOranges.java
		 */
		
		List<int[]> ls = new ArrayList<>();
		int islands = 0;
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					ls.add(new int[] {i, j});
				}
			}
		}
		
		/**
		 * We traverse one element at a time.
		 * If it is one, we offer its coordinates to deque.
		 * While deque is not empty, we keep turning poped element's neighbors to -1 (indicating it has been included, don't include it again) and also updating grid on the fly
		 */
		Deque<int[]> deque = new ArrayDeque<>();
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					islands++;
					deque.offerLast(new int[] {i,j});
					while(!deque.isEmpty()) {
						int[] poped = deque.pollFirst();
						int x = poped[0];
						int y = poped[1];
						for(int[] dir : dirs) {
							if(isSafe(x+dir[0], y+dir[1], grid)) {
								deque.offerLast(new int[] {x+dir[0], y+dir[1]});
								grid[x+dir[0]][y+dir[1]] = -1;
							}
						}
					}
				}
			}
		}
		
		return islands;
	}
	
	// driver - main method
	public static void main(String[] args) {
		NumberOfIslands noi = new NumberOfIslands();
		int[][] grid1 = new int[][] {
			{1,1,1,1,0},
			{1,1,0,1,0},
			{1,1,0,0,0},
			{0,0,0,0,0}
		};
		int[][] grid2 = new int[][] {
			{1,1,0,0,0},
			{1,1,0,0,0},
			{0,0,1,0,0},
			{0,0,0,1,1}
		};
		
		// TESTCASES
		System.out.println(noi.getNumberOfIslands(grid1));
		System.out.println(noi.getNumberOfIslands(grid2));

	}

}
