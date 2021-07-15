/**
 * Solve a 9x9 Sudoku puzzle by filling the empty cells from 1-9.
 * The '.' character in input indicates empty cells.
 * It is guaranteed that the input board is populated with enough characters so that problem has only one solution.
 */
package Backtracking;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since July 04, 2021
 */

public class Sudoku {
	
    private boolean isSafe(char[][] grid, int row, int col, int N, char x) {
    	// check in all col for given row
        for(int j=0; j<N; j++) {
            if(x == grid[row][j])
                return false;
        }
        // check for all rows in given col
        for(int i=0; i<N; i++) {
            if(x == grid[i][col])
                return false;
        }
        
        // check in subgrid/box to which (row, col) position belongs
        int sqrt = (int) Math.sqrt(N);		// since N is 9, so it will be 3
        int boxStartRow = row - row % sqrt;
        int boxStartCol = col - col % sqrt;
        for(int i=boxStartRow; i<boxStartRow + sqrt; i++) {
            for(int j=boxStartCol; j<boxStartCol + sqrt; j++) {
                if(x == grid[i][j])
                    return false;
            }
        }
        return true;
    }
    
    private boolean solver(char[][] grid, int N) {
    	/**
    	 * Logic:
    	 * Just like in N-Queen problem, here also we have constraint that says in a row and col (as well as in box/subgrid) there should be no duplicate (just like queen should not threat)
    	 * 
    	 * Time complexity: O(9^(N*N)). For every unassigned position (upper bound N*N), there are 9 possible options.
    	 * Space Complexity: O(N*N) (To store the output grid)
    	 */
        boolean isThisColFilled = true;
        int row = -1;
        int col = -1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(grid[i][j] == '.') {
                    isThisColFilled = false;
                    row = i;
                    col = j;
                    break;
                }
            }
            if(!isThisColFilled)
                break;
        }
        if(isThisColFilled)
            return true;
        for(int x='1'; x<='9'; x++) {
            if(isSafe(grid, row, col, N, (char)x)) {
                grid[row][col] = (char)x;
                if(solver(grid, N))
                    return true;
                grid[row][col] = '.';
            }
        }
        return false;
    }

	// driver - main method
	public static void main(String[] args) {
		char[][] grid = new char[][] {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};
		// TESTCASE
		new Sudoku().solver(grid, grid.length);
		// print
		Arrays.stream(grid).forEach(x -> {
			System.out.println(x);
		});
	}

}
