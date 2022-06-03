/*
Noughts and Crosses
Rules of the game

    The game is played between two players.
    One player owns the X pieces and can put it on any of the empty cells in the grid.
    The other player owns the O pieces and can in any of the empty cells.
    The player with X makes the first turn. Each player plays alternately after that.
    The first player to form a horizontal/vertical/diagonal sequence wins.
 */
package LowLevelSystemDesign;

/**
 * @author gaurav kabra
 * @since 02/Jun/2022
 **/

/*

private static final int boardDim = 3;
private static final int playerCount = 2;

 */
public class TicTacToe {

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
    }

}

class Game {
    private Board board;
    private Player[] players;
    private Player turn;
    private Status status;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getTurn() {
        return turn;
    }

    public void setTurn(Player turn) {
        this.turn = turn;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    Game(Board board, Player[] players, Status status) {
        this.board = board;
        this.players = players;
        this.status = status;
    }

    public void endGame() {
        System.exit(0);
    }
}

class Player extends Person {
    private Game game;
    private Symbol symbol;
    private int turn;

    public Player(Game game, Symbol symbol) {
        this.game = game;
        this.symbol = symbol;
        this.turn = 0;
    }

    public void put() {
        // ask for coordinate, hard-coded for now
        int x = 1;
        int y = 1;
        if (isValidMove(x, y)) {
            Cell[][] cells = game.getBoard().getCells();
            cells[x][y] = new Cell(x, y, symbol);
            game.getBoard().setCells(cells);
            if (isWon(x, y)) {
                // congratulate logic
                // end
                game.endGame();
            }
            this.turn = (this.turn + 1) % game.getPlayers().length;
            Player[] players = game.getPlayers();
            game.setTurn(players[this.turn]);
        } else {
            // handle exception
        }
    }

    private boolean isValidMove(int x, int y) {
        boolean dim = x > 0
                    && y > 0
                    && x < game.getBoard().getBoardDim()
                    && y < game.getBoard().getBoardDim();
        Cell[][] cells = game.getBoard().getCells();
        Cell currCell = cells[x][y];

        return dim
               && currCell.getSymbol() == Symbol.NONE;
    }


    private boolean isWon(int x, int y) {
        return isRowSatisfied(x)
                || isColSatisfied(y)
                || isLeftToRightDiagonalSatisfied(x, y)
                || isBottomToTopDiagonalSatisfied(x, y);
    }

    private boolean isBottomToTopDiagonalSatisfied(int x, int y) {
        Cell[][] cells = game.getBoard().getCells();
        for (int i=x, j=y; i>=0 && j<game.getBoard().getBoardDim(); i--, j++) {
            if (cells[i][j].getSymbol() != symbol)
                return false;
        }

        for (int i=x, j=y; i<game.getBoard().getBoardDim() && j>=0; i++, j--) {
            if (cells[i][j].getSymbol() != symbol)
                return false;
        }

        return true;
    }

    private boolean isLeftToRightDiagonalSatisfied(int x, int y) {
        Cell[][] cells = game.getBoard().getCells();
        for (int i=x, j=y; i>=0 && j >=0; i--, j--) {
            if (cells[i][j].getSymbol() != symbol)
                return false;
        }

        for (int i=x, j=y; i<game.getBoard().getBoardDim() && j<game.getBoard().getBoardDim(); i++, j++) {
            if (cells[i][j].getSymbol() != symbol)
                return false;
        }

        return true;
    }

    private boolean isColSatisfied(int y) {
        Cell[][] cells = game.getBoard().getCells();
        for (int i=0; i<game.getBoard().getBoardDim(); i++)
            if (cells[i][y].getSymbol() != symbol)
                return false;
        return true;
    }

    private boolean isRowSatisfied(int x) {
        Cell[][] cells = game.getBoard().getCells();
        for (int j=0; j<game.getBoard().getBoardDim(); j++)
            if (cells[x][j].getSymbol() != symbol)
                return false;
        return true;
    }
}

class Board {
    private Cell[][] cells;
    private int boardDim;

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getBoardDim() {
        return boardDim;
    }

    public void setBoardDim(int boardDim) {
        this.boardDim = boardDim;
    }

    Board (int boardDim) {
        this.boardDim = boardDim;
        cells = new Cell[boardDim][boardDim];
        for (int i=0; i<boardDim; i++) {
            for (int j=0; j<boardDim; j++) {
                cells[i][j] = new Cell (i, j, Symbol.NONE);
            }
        }
    }

    public void resetBoard() {
        // first confirm
        // then reset
        cells = new Cell[boardDim][boardDim];
    }
}


class Cell {
    private int x;
    private int y;
    private Symbol symbol;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    Cell(int x, int y, Symbol symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }
}


class Person {
    String username;
    String password;

    void encryptPassword() {

    }

    boolean verifyPassword(String password) {
        // logic to check
        return false;
    }
}

enum Status {
    ENDED_NOT_DRAW,
    ENDED_IN_DRAW,
    IN_PROGRESS
}

enum Symbol {
    X,
    O,
    NONE
}
