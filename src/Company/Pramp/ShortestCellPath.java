/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell
(i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different
    and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.
 */
package Company.Pramp;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author gaurav kabra
 * @since 28/Mar/2022
 **/

public class ShortestCellPath {

    private static class Pair {
        int x;
        int y;
        int dist;

        Pair (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static final int[][] dirs = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0},
            {-1, 1}, {1, 1}, {1, -1}, {-1, -1}
    };

    private static boolean isSafe(int[][] grid, int x, int y, int M, int N) {
        return x >= 0 &&
                y >= 0 &&
                x < M &&
                y < N &&
                grid[x][y] != 1;
    }

    /*
        Don't use DFS, it will give TLE for large inputs.
        REMEMBER - Shortest path => BFS

        TC : O(V+E) since E < 4*V so O(V) = O(M*N)
        SC : O(M*N)
     */
    private static int shortestPathBinaryMatrix(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        if (grid[0][0] == 1 || grid[M-1][N-1] == 1) {
            return -1;
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, 0, 1));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if (p.x == M-1 && p.y == N-1) {
                return p.dist;
            }

            for (int[] dir : dirs) {
                int nextX = p.x + dir[0];
                int nextY = p.y + dir[1];
                if (isSafe(grid, nextX, nextY, M, N)) {
                    grid[nextX][nextY] = 1;
                    queue.add(new Pair(nextX, nextY, p.dist+1));
                }
            }
        }

        return -1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(shortestPathBinaryMatrix(new int[][] {{0,1},{1,0}}));
    }

}
