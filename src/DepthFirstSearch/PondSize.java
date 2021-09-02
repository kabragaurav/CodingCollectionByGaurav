/**
 * You are given two-dimensional matrix that represents a plot of land.
 * Within the matrix there exist two values: ones which represent land and zeroes which represent water
 * within a pond. Given that parts of a pond can be connected both horizontally and vertically
 * (but not diagonally), return the largest pond size.
 * You may assume that each zero within a given pond contributes a value of one to the total size
 * of the pond.
 */
package DepthFirstSearch;

/**
 * @author gaurav kabra
 * @since 2 Sept 2021
 **/

public class PondSize {
    private static int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    private static boolean isSafe(int[][] grid, int i, int j, int M, int N) {
        return i >= 0 &&
                j >= 0 &&
                i < M &&
                j < N &&
                grid[i][j] == 0;
    }
    private static int dfs(int[][] grid, int i, int j, int M, int N, int areaSoFar) {
        /**
         * Logic:
         * If we are not in bounds, return area so far.
         * Else
         *      Set current cell to 1 so that we don't re-perform dfs on this (hence preventing INF loop)
         *      Look in 4 directions from the cell
         *      Get max area so far
         * Return max area so far
         */
        if(!isSafe(grid, i, j, M, N)) {
            return areaSoFar;
        }
        areaSoFar++;
        grid[i][j] = 1;
        for(int k=0; k<4; k++) {
           int area = dfs(grid, i + directions[k][0], j + directions[k][1], M, N, areaSoFar);
           if(area > areaSoFar) {
               areaSoFar = area;
           }
        }
        return areaSoFar;
    }

    private static int maxAreaOfIsland(int[][] grid) {
        /**
         * Logic:
         * We visit each cell in grid.
         * If cell == 0
         *      Get maximum area by starting at the cell by performing dfs.
         *      Update maximum area so far.
         * Return maximum area so far.
         */
        int M = grid.length, N = grid[0].length;
        int maxAreaSoFar = 0;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(grid[i][j] == 0) {
                    int area = dfs(grid, i, j, M, N, 0);
                    if(area > maxAreaSoFar) {
                        maxAreaSoFar = area;
                    }
                }
            }
        }
        return maxAreaSoFar;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));

        System.out.println(maxAreaOfIsland(new int[][] {{0,0,0,0,0,0,0,0}}));
    }
}
