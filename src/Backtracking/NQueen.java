/**
 * The N Queen is the problem of finding all arrangements of placing N chess queens on an N×N chessboard 
 * so that no two queens attack each other. 
 * Each solution should have a distinct board configuration of the N-queens' placement, 
 * where 'Q' and '.' indicate a queen and an empty space, respectively.
 */
package Backtracking;

/**
 * @author gaurav kabra
 * @since July 04, 2021
 */

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	
	List<List<String>> ls = new ArrayList<>();
    
    private boolean isSafe(char[][] grid, int N, int row, int currentCol) {
    	/**
    	 * Logic:
    	 * Since we start placing 'Q' from left to right columns, 
    	 * so for any given 'Q' that we want to place, the only threats can come from left side (left side of row, and left side diagonals)
    	 */
    	// check for all left columns in the row
        for(int j=0; j<currentCol; j++)
            if(grid[row][j] == 'Q')
                return false;
        // check for upper left diagonal 
        for(int i=row, j=currentCol; i>=0 && j>=0; i--, j--)
            if(grid[i][j] == 'Q')
                return false;
        // check for bottom left diagonal
        for(int i=row, j=currentCol; i<N && j>=0; i++, j--)
            if(grid[i][j] == 'Q')
                return false;
        return true;
    }
    
    private boolean queenHelper(char[][] grid, int N, int currentCol) {
    	/**
    	 * Logic:
    	 * Place queens one by one in different columns, starting from the leftmost column. 
    	 * When we place a queen in a column, we check for clashes with already placed queens using isSafe() method
    	 * In the current column, if we find a row for which there is no clash, we mark this row and column as part of the solution.
    	 * 
    	 * Time Complexity : O(N^N) or at least O(N!)
    	 * Space Complexity : O(N*N*k) where k is number of solutions for NxN chessboard
    	 */
        if(currentCol == N)
            return true;
        
        // i denotes row number for column currentCol
        for(int i=0; i<N; i++) {
            if(isSafe(grid, N, i, currentCol)) {	// checks if it safe to place 'Q' at grid[i][currentCol]
                grid[i][currentCol] = 'Q';
                
                if(queenHelper(grid, N, currentCol+1)) {	// check for next col
                	// convert char[][] to list of strings
                    List<String> t = new ArrayList<>();
                    for(char[] x : grid) {
                        t.add(new String(x));
                    }
                    ls.add(t);
                }
                
                grid[i][currentCol] = '.';		// backtrack
            }
        }
        return false;
    }
    
    public List<List<String>> solveNQueens(int N) {
    	// start from left most col
        int currentCol = 0;
        
        char[][] grid = new char[N][N];
        
        // initially fill grid with '.'
        for(int i=0; i<grid.length; i++) {
            grid[i] = ".".repeat(N).toCharArray();
        }

        queenHelper(grid, N, currentCol);
        return ls;
    }
    
    // driver - main method
	public static void main(String[] args) {
		// TESTCASE
		System.out.println(new NQueen().solveNQueens(4));
		// Note that half of the solutions are mirror-image of other halfs
	}
}
