/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or
walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any
number of moves.
 */
package DepthFirstSearch;

/**
 * @author gaurav kabra
 * @since 09/Apr/2022
 *
 *  This problem is very, very similar to
 *      NumberOfClosedIslands.java
 *      and
 *      number of islands problem
 **/

public class NumberOfEnclaves {

    private static final int LAND = 1;
    private static final int WATER = 0;
    private static int count = 0;

    private static final int[][] dirs = new int[][] {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    private static boolean isSafe(int M, int N, int row, int col, boolean[][] visited) {
        return row >= 0
                && col >= 0
                && row < M
                && col < N
                && !visited[row][col];
    }

    private static void dfs(int[][] grid, int M, int N, int row, int col, boolean[][] visited
            , boolean shouldUpdateCount) {

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isSafe(M, N, newRow, newCol, visited) && grid[newRow][newCol] == LAND) {
                if (shouldUpdateCount) {
                    count++;
                }
                visited[newRow][newCol] = true;
                dfs(grid, M, N, newRow, newCol, visited, shouldUpdateCount);
            }

        }

    }

    private static int numEnclaves(int[][] grid) {
        count = 0;
        int M = grid.length;
        int N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if ((i == 0 || j == 0 || i == M-1 || j == N-1) && grid[i][j] == LAND && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(grid, M, N, i, j, visited, false);
                }
            }
        }


        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (grid[i][j] == LAND && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    dfs(grid, M, N, i, j, visited, true);
                }
            }
        }

        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(numEnclaves(new int[][] {
                {0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}
        }));
    }

}
