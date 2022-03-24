/*
    Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

    Players take turns placing characters into empty squares ' '.
    The first player A always places 'X' characters, while the second player B always places 'O' characters.
    'X' and 'O' characters are always placed into empty squares, never on filled ones.
    The game ends when there are three of the same (non-empty) character filling any row, column, or
    diagonal.
    The game also ends if all squares are non-empty.
    No more moves can be played if the game is over.

    Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played
    on grid[rowi][coli]. return the winner of the game if it exists (A or B).
    In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

    You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty,
    and A will play first.
 */
package Arrays;

import java.util.Arrays;

/**
 * @author gauravkabra
 * @since 24/Mar/2022
 **/

public class TicTacToe {

    private static final int DIM = 3;

    private enum State {

        A("A"),
        B("B"),
        DRAW("Draw"),
        PENDING("Pending");

        private final String state;

        private State (String state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return this.state;
        }

    }

    /*
        TC : for each move we check for rows, cols and diagonals
            Mostly we break early. But for upper bound:
                N*(DIM*DIM+DIM*DIM+2*DIM) ~ O(N*DIM*DIM)

        SC : O(DIM*DIM) for board, DIM=3 here
     */
    private static String tictactoe(int[][] moves) {
        int player = 0;
        int N = moves.length;

        char[][] board = new char[DIM][DIM];
        Arrays.stream(board)
                .forEach(x -> Arrays.fill(x, '-'));

        for (int i=0; i<N; i++) {
            int[] move = moves[i];
            if (player == 0) {
                board[move[0]][move[1]] = 'x';
            } else {
                board[move[0]][move[1]] = 'o';
            }
            int checkState = getState(board, player);
            switch (checkState) {
                case 0:
                    return State.A.toString();
                case 1:
                    return State.B.toString();
            }
            player = 1 - player;
        }

        int checkState = getState(board, 1-player);

        switch (checkState) {
            case 0:
                return State.A.toString();
            case 1:
                return State.B.toString();
            case 2:
                return State.DRAW.toString();
            default:
                return  State.PENDING.toString();
        }

    }

    private static int getState(char[][] board, int player) {
        char ch = player == 0 ? 'x' : 'o';
        boolean allSame = true;

        for (int i=0; i<DIM; i++) {
            allSame = true;
            for (int j=0; j<DIM; j++) {
                if (board[i][j] != ch) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                return player;
            }
        }

        for (int i=0; i<DIM; i++) {
            allSame = true;
            for (int j=0; j<DIM; j++) {
                if (board[j][i] != ch) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                return player;
            }
        }

        allSame = true;
        for (int i=0; i<DIM; i++) {
            if (board[i][i] != ch) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            return player;
        }

        allSame = true;
        for (int i=0; i<DIM; i++) {
            if (board[i][DIM-1-i] != ch) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            return player;
        }

        for (int i=0; i<DIM; i++) {
            for (int j=0; j<DIM; j++) {
                if (board[i][j] == '-') {
                    return 3;
                }
            }
        }
        return 2;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(tictactoe(new int[][] {{0,0}, {1,1}}));
        System.out.println(tictactoe(new int[][] {{2,2},{0,2},{1,0},{0,1},{2,0},{0,0}}));
        System.out.println(tictactoe(new int[][] {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}));
    }

}
