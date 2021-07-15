/**
 * Given an MxN grid of characters and a string word, 
 * return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, 
 * where adjacent cells are horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 */
package DepthFirstSearch;

/**
 * @author gaurav kabra
 * @since July 02, 2021
 */

public class WordSearchInGrid {
	
	int[][] dirs = {
	        {0, 1},
	        {1, 0},
	        {0, -1},
	        {-1, 0}
	    };
	    
	    private boolean isWordPossible(char[][] grid, int x, int y, String word, String currentWord) {
	    	/**
	    	 * if we found whole word, return true.
	    	 * Else if current word we have constructed is not in word we want to have, return false.
	    	 * Else add current character to current word and make sure we don't come again to it by setting it to '-' temporarily
	    	 */
	        if(currentWord.equals(word))
	            return true;
	        if(!word.contains(currentWord) || (x >= grid.length || y >= grid[0].length || x < 0 || y < 0))
	            return false;
	        boolean ans = false;
	        String newCurrentWord = currentWord + grid[x][y];
	        char t = grid[x][y];
	        // set to '-' so we don't visit it again
	        grid[x][y] = '-';
	        for(int[] dir : dirs) {
	            ans = ans || isWordPossible(grid, x+dir[0], y+dir[1], word, newCurrentWord);
	            if(ans)
	                return true;
	        }
	        grid[x][y] = t;		// backtrack
	        return false;
	    }
	    
	    private boolean exist(char[][] grid, String word) {
	    	/**
	    	 * Logic:
	    	 * Go to each cell and start from there to find if word can be constructed
	    	 * 
	    	 * Time Complexity : O(MN4^L) where L is length of word
	    	 * Space Complexity : O(L) for each cell start
	    	 */
	        int rows = grid.length;
	        int cols = grid[0].length;
	        
	        
	        for(int i=0; i<rows; i++) {
	            for(int j=0; j<cols; j++) {
	                if(isWordPossible(grid, i, j, word, ""))
	                    return true;
	            }
	        }
	        return false;
	    }
	    
	// driver - main method
	public static void main(String[] args) {
		
		// TESTCASES
		char[][][] gridCollection = {
				{
					{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
				},
				{
					{'a', 'b'}, {'c', 'd'}
				},
				{
					{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'}
				}
		};
		
		String[] wordCollection = {
				"ABCB",
				"acdb",
				"AAAAAAAAAAAAAAB"
		};
		
		WordSearchInGrid wsig = new WordSearchInGrid();
		
		for(int i=0; i<3; i++) {
			System.out.println(wsig.exist(gridCollection[i], wordCollection[i]));
		}

	}

}
