/**
 * Write the function sudokuSolve that checks whether a given sudoku board
 * is solvable. If so, the function will return true.
 * Otherwise (i.e. there is no valid solution to the given sudoku board), returns false.
 *
 * Numbers are in form of chars.
 */
package Company.Pramp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gkabra
 * @since 05-03-2022 Sat
 **/

public class IsSudokuValid {

    private static boolean sudokuSolve(char[][] board) {
        int row = -1;
        int col = -1;
        List<Character> candidates = null;
        List<Character> newCandid = null;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {
                    newCandid = getCandidates(board, i, j);
                    if(newCandid != null && (candidates == null || candidates.size() > newCandid.size())) {
                        candidates = newCandid;
                        row = i;
                        col = j;
                    }
                }
            }
            if(candidates != null && candidates.size() > 0) {
                break;
            }
        }

        if(candidates == null) {        // all cells are filled
            return true;
        }

        for(char num : candidates) {
            board[row][col] = num;
            if(sudokuSolve(board)) {
                return true;
            }
            // backtrack
            board[row][col] = '.';
        }
        return false;
    }

    private static List<Character> getCandidates(char[][] board, int i, int j) {
        List<Character> ls = new ArrayList<>();
        for(char ch = '1'; ch <= '9'; ch++) {
            if(isValid(board, ch, i, j)) {
                ls.add(ch);
            }
        }
        return ls;
    }

    private static boolean isValid(char[][] board, char num, int i, int j) {
        // row
        for(int col=0; col<9; col++) {
            if(board[i][col] == num) {
                return false;
            }
        }

        // col
        for(int row=0; row<9; row++) {
            if(board[row][j] == num) {
                return false;
            }
        }

        // grid
        int startRow = i - i % 3;
        int startCol = j - j % 3;
        for(int row=startRow; row<startRow+3; row++) {
            for(int col=startCol; col<startCol+3; col++) {
                if(board[row][col] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(sudokuSolve(new char[][] {{'.','2','3','4','5','6','7','8','9'},{'1','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}}));
    }

}
