/*
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally
connected group of 0s and a closed island is an island totally (all left, top, right, bottom)
surrounded by 1s.

Return the number of closed islands.
 */
package DepthFirstSearch;

/**
 * @author gaurav kabra
 * @since 09/Apr/2022
 *
 * This problem is very, very similar to
 *      NumberOfEnclaves.java
 *      and
 *      number of islands problem
 **/

public class NumberOfClosedIslands {

    private static final int LAND = 0;
    private static final int WATER = 1;
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

    private static void dfs(int[][] grid, int M, int N, int row, int col, boolean[][] visited) {

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isSafe(M, N, newRow, newCol, visited) && grid[newRow][newCol] == LAND) {
                visited[newRow][newCol] = true;
                dfs(grid, M, N, newRow, newCol, visited);
            }

        }

    }

    private static int closedIsland(int[][] grid) {
        count = 0;
        int M = grid.length;
        int N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        // run dfs on boundary first to mark and rule out those islands for which
        // lands falls on boundary
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if ((i == 0 || j == 0 || i == M-1 || j == N-1) && grid[i][j] == LAND && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(grid, M, N, i, j, visited);
                }
            }
        }

        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (grid[i][j] == LAND && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    dfs(grid, M, N, i, j, visited);
                }
            }
        }

        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(closedIsland(new int[][] {
                {0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}
        }));
    }

}
