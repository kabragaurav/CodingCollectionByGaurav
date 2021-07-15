/**
 * Amazon
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Find the minimum number of minutes that must elapse until no cell has a fresh orange. 
 * If this never can happen, return -1.
 */
package Miscellaneous.UniqueConcepts;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author gaurav kabra
 * @since June 25, 2021
 */

public class RottenOranges {
	
	// direction : down, up, right, left
	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	
	// checks if orange can be offered to the deque
	private boolean isSafe(int x, int y, int[][] grid) {
		return  (x >= 0 && x < grid.length
				&& y>=0 && y < grid[0].length
				&& grid[x][y] == 1);
	}
	
	private int orangesRottingTime(int[][] grid) {
		/**
		 * Time Complexity : O(N^2) since we use two nested loops
		 * Space Complexity : O(N^2) since we use a deque to store coordinates of rotten oranges
		 */
		
		// will store coordinates of rotten oranges
        Deque<int[]> deque = new ArrayDeque<int[]>();
        
        /**
         * total = total number of oranges (fresh + rotten)
         * rotten = number of rotten oranges at beginning
         * time = time taken for all oranges to rot (initially 0 and -1 at end if some orange remains fresh at last)
         */
        int total = 0, rotten = 0, time = 0;
        
        /**
         * Find values for total and rotten variables
         * offer the coordinates of rotten oranges to deque
         */
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[i].length; j++) {
        		if(grid[i][j] != 0)
        			total++;
        		if(grid[i][j] == 2) {
        			rotten++;
        			deque.offerLast(new int[] {i,j});
        		}
        	}
        }
        
        
        while(!deque.isEmpty()) {
        	
        	int sz = deque.size();
        	boolean isAnyOneFresh = false;
       
        	for(int i=0; i<sz; i++) {
        		int[] poped = deque.pollFirst();
        		int x = poped[0];
        		int y = poped[1];
        		
        		for(int[] dir : dirs) {
        			if(isSafe(x + dir[0], y + dir[1], grid)) {
            			deque.offerLast(new int[] {x + dir[0], y + dir[1]});
            			isAnyOneFresh = true;
            			// once offered, set it to rotten so it cannot be offered again to deque
            			grid[x + dir[0]][y + dir[1]] = 2;
            			rotten++;
            		}
        		}
        	}
        	
        	// check if at least one new entry was inserted in deque
        	// E.g. if at last we have all rotten oranges in deque and we poll them but do not find any fresh orange to offer in deque that means we donot need to do time++ as all possible oranges are already rotten
        	if(isAnyOneFresh)
        		time++;
        }
        
        // all oranges must be rotten. If not then return -1
        return (total == rotten) ? time : -1; 
    }
	
	
	// driver - main method
	public static void main(String[] args) {
		RottenOranges ro = new RottenOranges();
		
		// TESTCASES
		System.out.println(ro.orangesRottingTime(new int[][] {
																{1,2}
															  }));
		
		System.out.println(ro.orangesRottingTime(new int[][] {
			{2,1,1},
			{1,1,0},
			{0,1,1}
		  }));	
		}
}
