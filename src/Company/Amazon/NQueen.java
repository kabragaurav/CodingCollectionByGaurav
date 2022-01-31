/**
 * The n-queens puzzle is the problem of placing n queens
 * on an n x n chessboard such that no two queens attack each other.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gkabra
 * @since 31-01-2022 Mon
 **/

public class NQueen {

    private static List<List<String>> ls = new ArrayList<>();

    private static boolean isSafe(char[][] grid, int N, int i, int currentCol) {
        for(int j=0; j<currentCol; j++)
            if(grid[i][j] == 'Q')
                return false;
        for(int k=i, j=currentCol; k>=0 && j>=0; k--, j--)      // top left diagonal \
            if(grid[k][j] == 'Q')
                return false;
        for(int k=i, j=currentCol; j>=0 && k<N; k++, j--)       // bottom right diagonal /
            if(grid[k][j] == 'Q')
                return false;
        return true;
    }

    private static boolean queenHelper(char[][] grid, int N, int currentCol) {
        if(currentCol == N)
            return true;
        for(int i=0; i<N; i++) {
            if(isSafe(grid, N, i, currentCol)) {
                grid[i][currentCol] = 'Q';
                if(queenHelper(grid, N, currentCol+1)) {
                    List<String> t = new ArrayList<>();
                    for(char[] x : grid) {
                        t.add(new String(x));
                    }
                    ls.add(t);
                }
                grid[i][currentCol] = '.';
            }
        }
        return false;
    }

    // TC : O(N^2)
    private static List<List<String>> solveNQueens(int N) {
        ls.clear();
        int currentCol = 0;
        char[][] grid = new char[N][N];
        Arrays.stream(grid).forEach(x -> Arrays.fill(x, '.'));
        queenHelper(grid, N, currentCol);
        return ls;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(solveNQueens(1));
        System.out.println(solveNQueens(4));
    }

}
