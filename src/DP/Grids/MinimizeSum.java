/**
 * Google, Amazon
 * Given an NxM matrix, grid, where each cell in the matrix represents the cost of stepping
 * on the current cell, return the minimum cost to traverse from the top-left hand corner of
 * the matrix to the bottom-right hand corner.
 * You can only traverse down, right and diagonally lower right cell from a given cell, i.e.,
 * from a given cell (i, j), cells (i+1, j), (i, j+1), and (i+1, j+1) can be traversed.
 */
package DP.Grids;

/**
 * @author gaurav kabra
 * @since 14 August 2021
 */

public class MinimizeSum {

    private static final int VERY_LARGE_INT = 1000000;  // a very big number which can be added safely to other integers without exceeding integer bounds

    private static boolean isSafe(int x, int y, int M, int N) {
        return x < M &&
                y < N &&
                x >= 0 &&
                y >= 0;
    }

    private static int getMinPathSumHelper(int[][] grid, int M, int N, int x, int y, int[][] cache) {
        /**
         * Logic:
         * Just like any other grid problem in DP, here we move in the three possible directions from present cell and
         * take minimum sum possible to reach bottom right.
         */
        if(!isSafe(x, y, M, N)) {
            return VERY_LARGE_INT;
        }
        if(x == M-1 && y == N-1) {
            return grid[x][y];
        }

        if(cache[x][y] != 0) {
            return cache[x][y];
        }
        return cache[x][y] = grid[x][y] + Math.min(getMinPathSumHelper(grid, M, N, x+1, y, cache),
                        Math.min(getMinPathSumHelper(grid, M, N, x, y+1, cache),
                                getMinPathSumHelper(grid, M, N, x+1, y+1, cache)));
    }

    private static int getMinPathSum(int[][] grid, int M, int N) {
        int[][] cache = new int [M][N];
        return getMinPathSumHelper(grid, M, N, 0, 0, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(getMinPathSum(new int[][]{
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} }, 3, 3));
        System.out.println(getMinPathSum(new int[][]{
                {1, 1, 3},
                {2, 3, 1},
                {4, 6, 1} }, 3, 3));
        System.out.println(getMinPathSum(new int[][]{
                {1, 8, 8, 1, 5},
                {4, 1, 1, 8, 1},
                {4, 2, 8, 8, 1},
                {1, 5, 8, 8, 1} }, 4, 5));
    }
}
